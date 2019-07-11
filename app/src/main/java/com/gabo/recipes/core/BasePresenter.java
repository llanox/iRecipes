package com.gabo.recipes.core;

import android.support.annotation.NonNull;

public class BasePresenter<V extends BaseView> {
    protected V view;

    public void attachView(@NonNull V view){
        this.view = view;
    }
    public void detachView() {
        this.view = null;
    }

    public boolean isValid(){
        return view!=null?true:false;
    }
}
