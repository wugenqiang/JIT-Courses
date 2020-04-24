/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jsp;


public class Counter {
//初始化JavaBean的成员变量
	int count = 0;
// Class构造器
	public Counter() {
	}
//属性count的Get方法
	public int getCount() {
//获取计数器的值，每一次请求都将计数器加1
	count++;
	return this.count;
	}
//属性Count的Set方法
	public void setCount(int count) {
	this.count = count;
	}
}
