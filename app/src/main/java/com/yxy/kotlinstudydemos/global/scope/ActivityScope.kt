package com.yxy.kotlinstudydemos.global.scope

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Scope

/**
 * @Title: ActivityScope
 * *
 * @Package:com.chinamall21.mobile.common.annotation
 * *
 * @Description:
 * *
 * @author: 赵志军(zhijun.zhao@21chinamall.com)
 * *
 * @date: 2016/5/25 9:42
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope
