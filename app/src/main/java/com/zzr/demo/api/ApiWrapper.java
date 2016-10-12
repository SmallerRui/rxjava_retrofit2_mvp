package com.zzr.demo.api;


import com.zzr.demo.modular.login.LoginModel;
import com.zzr.demo.modular.login.LoginParams;

import rx.Observable;

/**
 *  Api类的包装
 */
public class ApiWrapper extends Api {
    public Observable<LoginModel> login(LoginParams mLoginParams) {
        return applySchedulers(getService().login(mLoginParams));
    }
}
