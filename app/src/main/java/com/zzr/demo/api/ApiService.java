package com.zzr.demo.api;


import com.zzr.demo.module.login.LoginModel;
import com.zzr.demo.module.login.LoginParams;
import com.zzr.demo.module.one.ListModel;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Sunflower on 2015/11/4.
 */
public interface ApiService {

    /**
     * 获取个人信息
     */
    @POST("login.php")
    Observable<LoginModel> login(@Body LoginParams mLoginParams);
    @POST("data.php")
    Observable<ListModel> getList();

}
