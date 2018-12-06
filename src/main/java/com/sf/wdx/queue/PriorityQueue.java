package com.sf.wdx.queue;

/**
 * 描述：优先级队列，数据项按关键字的值排序，数据项插入的时候会按照顺序插入到合适的位置
 * 		没有设置队头和队尾指针，而是使数组的第一个元素永远是队尾，数组的最后一个元素永远是队头，便于移除。
 * 		除了可以快速访问优先级最高的数据项，优先级队列还应该可以实现相当快的插入，因此，优先级队列通常使用一种称为堆的数据结构来实现。在下例中，简便起见，我们仍然使用数组来实现。
 * @author 80002888
 * @date 2018年10月8日
 */
public class PriorityQueue<T> {
	
	public static void main(String[] args) throws Exception {
		// 按照到基准点的绝对值来排序，若基准点比所有队列中的值都大则为升序，若基准点比所有队列中的值都小则为降序。
		// 升序
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10, (int)Math.pow(2, 10));
		priorityQueue.insert(3);
		priorityQueue.insert(1);
		priorityQueue.insert(4);
		priorityQueue.insert(2);
		priorityQueue.display();
		// 降序
		priorityQueue = new PriorityQueue<>(10, -(int)Math.pow(2, 10));
		priorityQueue.insert(3);
		priorityQueue.insert(1);
		priorityQueue.insert(4);
		priorityQueue.insert(2);
		priorityQueue.display();
	}
	
	private T[] queArray;
	private int maxSize;
	private int length; // 队列长度
	private T referencePoint; // 基准点

	// 构造方法，初始化队列
	@SuppressWarnings("unchecked")
	public PriorityQueue(int maxSize, T referencePoint) {
		this.maxSize = maxSize;
		this.referencePoint = referencePoint;
		queArray = (T[]) new Object[maxSize];
		length = 0;
	}

	// 插入
	public void insert(T elem) throws Exception {
		if (isFull()) {
			throw new Exception("队列已满，不能进行插入操作！");
		}

		// 如果队列为空，插入到数组的第一个位置
		if (length == 0) {
			queArray[length++] = elem;
		} else {
			int i;
			for (i = length; i > 0; i--) {
				// 待插入元素的距离
				int dis = Math.abs(elem.hashCode() - referencePoint.hashCode()); 
				// 当前元素的距离
				int curDis = Math.abs(queArray[i - 1].hashCode() - referencePoint.hashCode());
				// 这里控制元素排序顺序
				if (dis >= curDis) {
					// 将比插入元素优先级高的元素后移一位
					queArray[i] = queArray[i - 1];
				} else {
					break;
				}
			}
			queArray[i] = elem;
			length++;
		}
	}

	// 移除
	public T remove() throws Exception {
		if (isEmpty()) {
			throw new Exception("队列为空，不能进行移除操作！");
		}
		T elem = queArray[--length];
		return elem;
	}

	// 查看队头元素
	public T peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("队列内没有元素！");
		}
		return queArray[length - 1];
	}

	// 返回队列长度
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
		for (int i = 0; i < length; i++) {
			System.out.print(queArray[i] + "\t");
		}
		System.out.println();
	}

}
