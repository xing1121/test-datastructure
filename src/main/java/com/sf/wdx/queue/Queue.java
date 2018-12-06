package com.sf.wdx.queue;

/**
 * 描述：队列，是一种“先进先出，后进后出”的数据结构，添加和移除数据时移动队头和队尾，环形结构
 * 		栈和队列是比数组和其他数据结构更加抽象的结构，是站在更高的层面对数据进行组织和维护
 * @author 80002888
 * @date 2018年10月8日
 */
public class Queue<T> {
	
	public static void main(String[] args) throws Exception {
		Queue<String> queue = new Queue<>(10);
		
		queue.insert("A");
		queue.insert("B");
		queue.insert("A");
		queue.insert("C");
		queue.insert("1");
		queue.insert("3");
		queue.insert("5");
		queue.display();
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.display();
	}

	private T[] queArray;
	private int maxSize;
	public int front; // 存储队头元素的下标
	public int rear; // 存储队尾元素的下标
	private int length; // 队列长度

	// 构造方法，初始化队列
	@SuppressWarnings("unchecked")
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		queArray = (T[]) new Object[maxSize];
		front = 0;
		rear = -1;
		length = 0;
	}

	// 插入
	public void insert(T elem) throws Exception {
		if (isFull()) {
			throw new Exception("队列已满，不能进行插入操作！");
		}
		// 如果队尾指针已到达数组的末端，插入到数组的第一个位置
		if (rear == maxSize - 1) {
			rear = -1;
		}
		queArray[++rear] = elem;
		length++;
	}

	// 移除
	public T remove() throws Exception {
		if (isEmpty()) {
			throw new Exception("队列为空，不能进行移除操作！");
		}
		T elem = queArray[front++];
		// 如果队头指针已到达数组末端，则移到数组第一个位置
		if (front == maxSize) {
			front = 0;
		}
		length--;
		return elem;
	}

	// 查看队头元素
	public T peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("队列内没有元素！");
		}
		return queArray[front];
	}

	// 获取队列长度
	public int size() {
		return length;
	}

	// 判空
	public boolean isEmpty() {
		return (length == 0);
	}

	// 判满
	public boolean isFull() {
		return (length == maxSize);
	}
	
	// 打印
	public void display(){
		for (int i = front; i <= rear; i++) {
			System.out.print(queArray[i] + "\t");
		}
		System.out.println();
	}

}
