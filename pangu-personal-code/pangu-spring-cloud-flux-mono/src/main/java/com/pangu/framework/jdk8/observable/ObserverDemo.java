package com.pangu.framework.jdk8.observable;

import java.util.Observable;

/**
 * @author qianpz
 * @since 2022-11-29 16-08
 */
public class ObserverDemo extends Observable {
	public static void main(String[] args) {
		ObserverDemo observerDemo = new ObserverDemo();
		//添加观察者
		observerDemo.addObserver(((o, arg) -> {
			System.out.println("数据发生变化A");
		}));
		observerDemo.addObserver(((o, arg) -> {
			System.out.println("数据发生变化B");
		}));
		//将此Observable对象记为已更改
		observerDemo.setChanged();
		//如果该对象发生了变化，则通知所有观察者
		observerDemo.notifyObservers();
	}
}
