package com.sf.wdx.link;

/**
 * 描述：有序单端链表的封装类
 * @author 80002888
 * @date   2018年10月12日
 */
public class SortedLinkList<T> {
	
	public static void main(String[] args) {
		SortedLinkList<Integer> list = new SortedLinkList<>();
		list.insert(6);
		list.insert(1);
		list.insert(3);
		list.insert(5);
		list.insert(2);
		list.insert(4);
		list.dispaly();
		
		System.out.println("删除第一个元素：" + list.deleteFirst());
		list.dispaly();
		
		System.out.println("删除第一个元素：" + list.deleteFirst());
		list.dispaly();
		
		System.out.println("删除4：" + list.delete(4));
		list.dispaly();
	}
	
	// 指向链表中的第一个链结点
	private OneWayLink<T> first; 

	// 插入
	public void insert(T t){
		if (isEmpty()) {
			first = new OneWayLink<T>(t, null);
			return;
		}
		OneWayLink<T> pre = null;
		OneWayLink<T> cur = first;
		// 找到位置
		while (cur != null && t.hashCode() > cur.get().hashCode()) {
			pre = cur;
			cur = cur.getNext();
		}
		// 插在第一个
		if (pre == null) {
			first = new OneWayLink<T>(t, cur);
			return;
		}
		// 插在指定位置
		OneWayLink<T> link = new OneWayLink<T>(t, cur);
		pre.setNext(link);
	}

	// 删除第一个链结点，返回删除的链结点引用
	public T deleteFirst(){
		if (isEmpty()) {
			System.out.println("链表为空，无法删除！");
			return null;
		}
		OneWayLink<T> res = first;
		first = res.getNext();
		return res.get();
	}
	
	// 删除指定元素
	public T delete(T t){
		if (isEmpty()) {
			System.out.println("链表为空，无法删除！");
			return null;
		}
		OneWayLink<T> cur = first;
		OneWayLink<T> pre = null;
		while (cur != null && !cur.get().equals(t)) {
			pre = cur;
			cur = cur.getNext();
		}
		if (cur == null) {
			System.out.println("链表中找不到要删除的元素");
			return null;
		}
		pre.setNext(cur.getNext());
		return cur.get();
	}

	// 判断是否空
	public boolean isEmpty(){
		return first == null;
	}
	
	// 打印
	public void dispaly(){
		OneWayLink<T> cur = first;
		while (cur != null) {
			System.out.print(cur.toString() + "\t");
			cur = cur.getNext();
		}
		System.out.println();
	}

}
