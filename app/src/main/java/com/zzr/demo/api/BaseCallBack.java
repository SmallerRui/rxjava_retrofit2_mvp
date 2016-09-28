package com.zzr.demo.api;


import com.zzr.demo.HttpExceptionBean;

/**
 * 发送请求后的回调接口
 */

interface BaseCallBack<T>  {
   void onCompleted();
   void onError(HttpExceptionBean mHttpExceptionBean);
   void onNext(T t);
}
