package com.zzr.demo.base;

import java.lang.ref.WeakReference;

/**
 * Created by SmallerRui on 2016/7/5.
 */

public abstract class BasePresenter<T> {
    protected abstract void unsubscribe();

    public WeakReference<T> view;

    public void onBind(T view) {
        this.view = new WeakReference<T>(view);
    }

    public void unBind() {
        if (view != null) {
            view.clear();
        }
    }
}