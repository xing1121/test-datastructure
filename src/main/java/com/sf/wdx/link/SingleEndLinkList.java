package com.sf.wdx.link;

/**
 * 描述：单端链表的封装类（只有first）
 * @author 80002888
 * @date   2018年10月12日
 */
public class SingleEndLinkList<T> {
	
	public static void main(String[] args) {
		SingleEndLinkList<String> list = new SingleEndLinkList<>();
		list.insertFirst("A");
		list.insertFirst("B");
		list.insertFirst("C");
		list.insertFirst("D");
		list.insertFirst("B");
		list.insertFirst("E");
		list.insertFirst("B");
		list.dispaly();
		
		System.out.println("删除第一个元素：" + list.deleteFirst());
		list.dispaly();
		
		System.out.println("删除B：" + list.delete("B"));
		list.dispaly();
		
		System.out.println("删除C：" + list.delete("C"));
		list.dispaly();
		
		System.out.println("当前第一个元素：" + list.getFirst());
	}

	// 单端链表中第一个元素
	private OneWayLink<T> first;
	
	// 插入到链表的前端
	public void insertFirst(T t){
		if (isEmpty()) {
			first = new OneWayLink<>(t, null);
			return;
		}
		OneWayLink<T> link = new OneWayLink<>(t, first);
		first = link;
	}
	
	// 获取单端链表中第一个元素
	public T getFirst(){
		return first.get();
	}
	
	// 删除链表第一个元素并返回
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
