package com.zzr.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zzr.demo.base.BaseActivity;
import com.zzr.demo.base.BaseFragment;
import com.zzr.demo.base.BasePresenter;
import com.zzr.demo.module.one.OneFragment;
import com.zzr.demo.utils.FragmentFactory;
import com.zzr.demo.widgets.IMainView;

import butterknife.BindView;

public class MainActivity extends BaseActivity<IMainView, MainPresenter> implements IMainView, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.main_rg)
    RadioGroup mainRg;
    private SparseArray<Fragment> mainFragments;
    private static String mCurrentFragmentTag;
    private static BaseFragment mCurrentFragment;
    private BaseFragment toFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void bindEvent() {

    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }


    @Override
    public void initView() {
        toolbarTitle.setText("hello toolbar");
        toolbar.setNavigationIcon(null);
        toolbar.inflateMenu(R.menu.main_menu);
        mainRg.setOnCheckedChangeListener(this);
        switchContent(OneFragment.class.getName());
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }


    /**
     * 切换Fragment
     *
     * @throws Exception
     */
    public void switchContent(String tag) {
        mCurrentFragmentTag = tag;
        toFragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (toFragment == null) {
            toFragment = FragmentFactory.getFragmentByTag(tag);
            if (toFragment == null) {
                throw new NullPointerException("you should create a new Fragment by Tag" + tag);
            }
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_content, toFragment, tag);
            if (mCurrentFragment != null) {
                fragmentTransaction.hide(mCurrentFragment);
            }
            fragmentTransaction.commit();
            mCurrentFragment = toFragment;
        } else {
            if (mCurrentFragment == toFragment) {
                return;
            }
            if (!toFragment.isAdded()) {
                FragmentTransaction fmt = getSupportFragmentManager().beginTransaction();
                if (mCurrentFragment != null) {
                    fmt.hide(mCurrentFragment);
                }
                fmt.add(R.id.frame_content, toFragment, tag);
                fmt.commit();
                mCurrentFragment = toFragment;
            } else {
                FragmentTransaction fmt = getSupportFragmentManager().beginTransaction();
                if (mCurrentFragment != null) {
                    fmt.hide(mCurrentFragment);
                }
                fmt.show(toFragment).commit();
                mCurrentFragment = toFragment;
            }
        }
    }
}
