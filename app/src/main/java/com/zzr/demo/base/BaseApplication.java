/*
    ShengDao Android Client, BaseApplication
    Copyright (c) 2014 ShengDao Tech Company Limited
 */

package com.zzr.demo.base;

import android.app.Application;
import android.content.Context;

import com.zzr.demo.common.ActivityPageManager;
import com.zzr.demo.utils.LogUtil;


/**
 * [系统Application类，设置全局变量以及初始化组件]
 *
 * @author SmallerRui
 * @version 1.1
 **/
public class BaseApplication extends Application  {
    private final String tag = BaseApplication.class.getSimpleName();
    private static BaseApplication instance;
    public static Context myContext;
    /*
     * 是否完成  整个项目
     */
    public static boolean isCompleteProject = false;
    public static final boolean ISDEBUG = false;
    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        myContext = this;
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        LogUtil.setDebug(!isCompleteProject);
        LogUtil.e(tag, "isDebug: " + !isCompleteProject);
    }

    /**
     * 退出应用
     */
    public void exit() {
        ActivityPageManager.getInstance().exit(this);
    }

}
