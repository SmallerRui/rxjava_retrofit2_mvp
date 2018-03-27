package com.zzr.demo.module.one;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.zzr.demo.R;
import com.zzr.demo.R.layout;
import com.zzr.demo.base.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * O\ = /O
 * ____/`---'\____
 * .   ' \\| |// `.
 * / \\||| : |||// \
 * / _||||| -:- |||||- \
 * | | \\\ - /// | |
 * | \_| ''\---/'' | |
 * \ .-\__ `-` ___/-. /
 * ___`. .' /--.--\ `. . __
 * ."" '< `.___\_<|>_/___.' >'"".
 * | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 * <p>
 * .............................................
 * 佛祖保佑             永无BUG
 * 佛曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 * Created by zhangzhenrui on 16/9/29.
 * description
 */

public class OneFragment extends BaseFragment<ListPresenter> implements ListContract.view {
    @BindView(R.id.fm_one_plv)
    PullToRefreshRecyclerView prv;
    ListAdapter mAdapter;

    @Override
    public int onSetLayoutId() {
        return layout.fm_one;
    }

    @Override
    public void initView() {
        presenter = new ListPresenter(this);
        presenter.getList();
        prv.setLayoutManager(new LinearLayoutManager(mContext));
    }


    @Override
    public void bindEvent() {

    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void setMDate(List<String> mData) {
        mAdapter = new ListAdapter(mContext, mData, android.R.layout.simple_list_item_1);
        prv.setAdapter(mAdapter);
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void hideLoading() {

    }
}
