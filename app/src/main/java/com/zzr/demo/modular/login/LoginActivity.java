package com.zzr.demo.modular.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.zzr.demo.MainActivity;
import com.zzr.demo.R;
import com.zzr.demo.base.BaseActivity;
import com.zzr.demo.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
 * Created by zhangzhenrui on 16/9/30.
 * description
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_pwd)
    EditText loginPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void bindEvent() {

    }

    @Override
    @OnClick(R.id.btn_submit)
    public void onClick(View v) {
        String userName = loginUsername.getText() == null ? "" : loginUsername.getText().toString();
        String pwd = loginPwd.getText() == null ? "" : loginPwd.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            ToastUtils.show("用户名不能为空", 1000);
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.show("密码不能为空", 1000);
            return;
        }
        LoginParams params = new LoginParams(userName, pwd);
        presenter.login(params);
    }

    @Override
    public void loginSuccess() {
        skipAct(MainActivity.class);
    }

    @Override
    public void loginError(String msg) {

    }

    @Override
    public void hideLoading() {

    }
}
