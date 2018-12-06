package com.sf.wdx.link;

/**
 * 描述：双端链表的封装类（有first和last）
 * 
 * @author 80002888
 * @date 2018年10月12日
 */
public class DoubleEndLinkList<T> {
	
	public static void main(String[] args) {
		DoubleEndLinkList<String> list = new DoubleEndLinkList<String>();
		list.insertFirst("A");
		list.insertFirst("B");
		list.insertFirst("C");
		list.insertLast("P");
		list.insertFirst("D");
		list.insertLast("Q");
		list.dispaly();
		
		System.out.println("第一个元素：" + list.getFirst());
		System.out.println("最后一个元素：" + list.getLast());
		
		System.out.println("删除第一个元素：" + list.deleteFirst());
		System.out.println("删除第一个元素：" + list.deleteFirst());
		list.dispaly();
		
		System.out.println("删除P：" + list.delete("P"));
		list.dispaly();
	}
	
	// 双端链表中第一个元素
	private OneWayLink<T> first;

	// 双端链表中最后一个元素
	private OneWayLink<T> last;
	
	// 插入到链表的前端
	public void insertFirst(T t) {
		if (isEmpty()) {
			OneWayLink<T> single = new OneWayLink<>(t, null);
			first = single;
			last = single;
			return;
		}
		OneWayLink<T> newFirst = new OneWayLink<>(t, first);
		first = newFirst;
	}

	// 插入到链表的末端
	public void insertLast(T t){
		if (isEmpty()) {
			OneWayLink<T> single = new OneWayLink<>(t, null);
			first = single;
			last = single;
			return;
		}
		OneWayLink<T> cur = new OneWayLink<>(t, null);
		last.setNext(cur);
		last = cur;
	}
	
	// 获取双端链表中第一个元素
	public T getFirst(){
		return first.get();
	}
	
	// 获取双端链表中最后一个元素
	public T getLast(){
		return last.get();
	}
	
	// 删除链表第一个元素并返回
	public T deleteFirst() {
		if (isEmpty()) {
			System.out.println("链表为空，无法删除！");
			return null;
		}
		OneWayLink<T> res = first;
		if (first == last) {
			last = null;
			first = null;
		} else {
			first = res.getNext();
		}
		return res.get();
	}
	
	// 删除指定元素
	public T delete(T t) {
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
	public boolean isEmpty() {
		return first == null;
	}

	// 打印
	public void dispaly() {
		OneWayLink<T> cur = first;
		while (cur != null) {
			System.out.print(cur.toString() + "\t");
			cur = cur.getNext();
		}
		System.out.println();
	}
	
}
