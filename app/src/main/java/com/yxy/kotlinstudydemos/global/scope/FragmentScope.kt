package com.yxy.kotlinstudydemos.global.scope

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Scope

/**
 * 包名:com.chinamall21.mobile.common.annotations
 * 对象名: FragmentScope
 * 描述:注解限定作用域范围，在Fragment生命周期有效
 * 作者: 赵志军
 * 邮箱：zhijun.zhao@21chinamall.com
 * 创建日期: 2016/5/31 9:40
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class FragmentScope
