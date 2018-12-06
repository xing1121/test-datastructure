package com.sf.wdx.link;

/**
 * 描述：双向链结点的封装类
 * @author 80002888
 * @date 2018年10月12日
 */
public class TwoWayLink<T> {

	// 当前链节点中存储的元素
	private T t;

	// 当前链节点指向的下一元素
	private TwoWayLink<T> next; 
	
	// 当前链节点指向的上一元素
	private TwoWayLink<T> previous; 

	public TwoWayLink(T t, TwoWayLink<T> next, TwoWayLink<T> previous) {
		this.t = t;
		this.next = next;
		this.previous = previous;
	}

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}

	public TwoWayLink<T> getNext() {
		return next;
	}

	public void setNext(TwoWayLink<T> next) {
		this.next = next;
	}

	public TwoWayLink<T> getPrevious() {
		return previous;
	}

	public void setPrevious(TwoWayLink<T> previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return t.toString();
	}
	
}
