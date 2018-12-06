package com.sf.wdx.link;

/**
 * 描述：单向链节点（指向下一个cur->next）的封装类
 * @author 80002888
 * @date   2018年10月12日
 */
public class OneWayLink<T> {
	
	// 当前链节点中存储的元素
	private T t;
	
	// 当前链节点指向的下一元素
	private OneWayLink<T> next;

	public OneWayLink(T t, OneWayLink<T> next) {
		this.t = t;
		this.next = next;
	}

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}

	public OneWayLink<T> getNext() {
		return next;
	}

	public void setNext(OneWayLink<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return t.toString();
	}
	
}
