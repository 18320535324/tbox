package com.jjfinder.tbox.base.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jjfinder.jbase.common.service.MyService;

public class BaseController<T> {
	private MyService<T> myService;

    private Class baseClass;

    protected void setBaseService(MyService myService) {
        this.myService = myService;
    }

    protected void setClass(Class clazz) {
        this.baseClass = clazz;
    }

}
