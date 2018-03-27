package com.zzr.demo.api;


import com.zzr.demo.module.login.LoginModel;
import com.zzr.demo.module.login.LoginParams;
import com.zzr.demo.module.one.ListModel;

import rx.Observable;

/**
 *  Api类的包装
 */
public class ApiWrapper extends Api {
    public Observable<LoginModel> login(LoginParams mLoginParams) {
        return applySchedulers(getService().login(mLoginParams));
    }
    public Observable<ListModel> getList(){
        return applySchedulers(getService().getList());
    }
}
