package com.sf.wdx.link;

/**
 * 描述：双向链表的封装类
 * @author 80002888
 * @date   2018年10月12日
 */
public class DoublelyLinkList<T> {
	
	public static void main(String[] args) {
		DoublelyLinkList<String> list = new DoublelyLinkList<>();
		list.insertLast("M");
		list.insertLast("N");
		list.dispaly();
		
		list.insertFirst("A");
		list.insertFirst("C");
		list.insertFirst("B");
		list.dispaly();
		
		list.insertLast("D");
		list.insertLast("E");
		list.dispaly();
		
		System.out.println("删除C：" + list.delete("C"));
		list.dispaly();
		
		System.out.println("删除B：" + list.delete("B"));
		list.dispaly();
		
		System.out.println("删除E：" + list.delete("E"));
		list.dispaly();
		
		System.out.println("删除第一个元素：" + list.deleteFirst());
		list.dispaly();
		
		System.out.println("删除最后一个元素：" + list.deleteLast());
		list.dispaly();
		
		System.out.println("删除F：" + list.delete("F"));
		list.dispaly();
		
		System.out.println("删除N：" + list.delete("N"));
		list.dispaly();
		
		System.out.println("在N后插入O：");
		list.insertAfter("N", "O");
		list.dispaly();
		
		System.out.println("在M后插入O：");
		list.insertAfter("M", "O");
		list.dispaly();
		
		System.out.println("在M后插入I：");
		list.insertAfter("M", "I");
		list.dispaly();
		
		System.out.println("在O后插入U：");
		list.insertAfter("O", "U");
		list.dispaly();
		
		System.out.println("在P后插入Q：");
		list.insertAfter("P", "Q");
		list.dispaly();
	}

	// 链表中第一个元素
	private TwoWayLink<T> first;
	
	// 链表中最后一个元素
	private TwoWayLink<T> last;
	
	// 插入到链表的前端
	public void insertFirst(T t){
		if (isEmpty()) {
			TwoWayLink<T> link = new TwoWayLink<>(t, null, null);
			first = link;
			last = link;
			return;
		}
		TwoWayLink<T> cur = new TwoWayLink<>(t, first, first.getPrevious());
		first.setPrevious(cur);
		first = cur;
	}
	
	// 插入到链表的末端
	public void insertLast(T t){
		if (isEmpty()) {
			TwoWayLink<T> link = new TwoWayLink<>(t, null, null);
			first = link;
			last = link;
			return;
		}
		TwoWayLink<T> cur = new TwoWayLink<>(t, last.getNext(), last);
		last.setNext(cur);
		last = cur;
	}
	
	// 在指定元素后面插入元素
	public void insertAfter(T demo, T t){
		if (isEmpty() || demo == null || t == null) {
			System.out.println("为空无法在" + demo + "后面插入");
			return;
		}
		// 只有一个元素
		if (first == last) {
			// demo与这个元素相等
			if (first.get().equals(demo)) {
				TwoWayLink<T> link = new TwoWayLink<>(t, null, first);
				last = link;
				first.setNext(last);
				return;
			} else {
				// demo与这个元素不相等
				System.out.println("找不到" + demo + "元素");
				return;
			}
		}
		
		TwoWayLink<T> cur = first;
		TwoWayLink<T> next = first.getNext();
		
		while (cur != null && !cur.get().equals(demo)) {
			cur = next;
			if (cur == null) {
				System.out.println("链表中找不到" + demo + "元素");
				return;
			}
			next = next.getNext();
		}
		TwoWayLink<T> link = new TwoWayLink<>(t, next, cur);
		cur.setNext(link);
		if (next != null) {
			next.setPrevious(link);
		} else {
			last = link;
		}
		
	}
	
	// 删除第一个元素
	public T deleteFirst(){
		if (isEmpty()) {
			System.out.println("链表为空，无法删除！");
			return null;
		}
		TwoWayLink<T> res = first;
		if (first == last) {
			last = null;
			first = null;
		} else {
			first = res.getNext();
			res.getNext().setPrevious(null);
		}
		return res.get();
	}
	
	// 删除最后一个元素
	public T deleteLast(){
		if (isEmpty()) {
			System.out.println("链表为空，无法删除！");
			return null;
		}
		TwoWayLink<T> res = last;
		if (first == last) {
			last = null;
			first = null;
		} else {
			last = res.getPrevious();
			res.getPrevious().setNext(null);
		}
		return res.get();
	}
	
	// 删除指定元素
	public T delete(T t){
		if (isEmpty()) {
			System.out.println("链表为空，无法删除！");
			return null;
		}
		TwoWayLink<T> cur = first;
		TwoWayLink<T> pre = null;
		TwoWayLink<T> next = first.getNext();
		// 只一个元素
		if (next == null) {
			if (cur.get().equals(t)) {
				first = null;
				last = null;
				return cur.get();
			} else {
				System.out.println("链表中找不到要删除的元素");
				return null;
			}
		}
		// 超过一个元素
		while (cur != null && !cur.get().equals(t)) {
			pre = cur;
			cur = next;
			if (cur == null) {
				System.out.println("链表中找不到要删除的元素");
				return null;
			}
			next = next.getNext();
		}
		if (pre != null) {
			pre.setNext(next);
		} else {
			first = next;
		}
		if (next != null) {
			next.setPrevious(pre);
		} else {
			last = pre;
		}
		return cur.get();
	}
	
	// 判断是否空
	public boolean isEmpty() {
		return first == null;
	}

	// 打印
	public void dispaly() {
		TwoWayLink<T> cur = first;
		while (cur != null) {
			if (cur == first) {
				System.out.print("first:" + cur + "\t" + "---" + "\t");
			}
			System.out.print(cur.toString() + "\t");
			if (cur == last) {
				System.out.print("---" + "last:" + cur + "\t");
			}
			cur = cur.getNext();
		}
		System.out.println();
	}
	
}
