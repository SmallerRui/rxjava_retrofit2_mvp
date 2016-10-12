package com.zzr.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zzr.demo.base.BaseActivity;
import com.zzr.demo.modular.one.OneFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.main_rg)
    RadioGroup mainRg;
    private SparseArray<Fragment> mainFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void bindEvent() {

    }


    @Override
    public void initView() {
        toolbarTitle.setText("hello toolbar");
        toolbar.setNavigationIcon(null);
        toolbar.inflateMenu(R.menu.main_menu);
        mainRg.setOnCheckedChangeListener(this);
        try {
            changeFragment(OneFragment.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.replace(R.id.frame_content,new OneFragment());
//        ft.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    /**
     * 切换布局页面
     *
     * @param tag fragment对应的Tag标示（用Fragment的类名作为其Tag）
     */
    private void changeFragment(String tag) throws Exception {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = (Fragment) Class.forName(tag).newInstance();
            transaction.add(R.id.frame_content, fragment, tag);
        } else {
            transaction.show(fragment);
        }
        for (int i = 0; i < mainFragments.size(); i++) {
            Fragment tempF = manager.findFragmentByTag(mainFragments.get(i).getClass().getName());
            if (tempF != null && !tempF.getTag().equals(tag)) {
                transaction.hide(tempF);
            }
        }
        transaction.commit();
    }
}
