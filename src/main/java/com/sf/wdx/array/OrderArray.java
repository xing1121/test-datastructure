package com.sf.wdx.array;

/**
 * 描述：有序数组（按照hashCode排序） 
 *     有序数组的优点：查找效率高 有序数组的缺点：删除和插入慢，大小固定
 * @author 80002888
 * @date 2018年10月8日
 */
public class OrderArray<T> {
	
	public static void main(String[] args) {
		OrderArray<Integer> orderArray = new OrderArray<Integer>(5);

		orderArray.insert(3);
		orderArray.insert(4);
		orderArray.insert(6);
		orderArray.insert(8);

		int i = orderArray.find(8);
		System.out.println("在队列中的位置是" + i);

		orderArray.insert(5);
		orderArray.display();
	}
	
	private T[] intArray;
	private int length = 0; // 数组元素个数

	// 构造方法，传入数组最大长度
	@SuppressWarnings("unchecked")
	public OrderArray(int max) {
		intArray = (T[]) new Object[max];
	}

	// 用二分查找法定位某个元素，如果存在返回其下标，不存在则返回-1
	public int find(T target) {
		int lowerBound = 0; // 搜索段最小元素的小标
		int upperBound = length - 1; // 搜索段最大元素的下标
		int curIn; // 当前检测元素的下标

		if (upperBound < 0) { // 如果数组为空，直接返回-1
			return -1;
		}

		while (true) {
			curIn = (lowerBound + upperBound) / 2;

			if (target.hashCode() == intArray[curIn].hashCode()) {
				return curIn;
			} else if (curIn == lowerBound) { // 在当前下标与搜索段的最小下标重合时，代表搜索段中只包含1个或2个元素
				// 既然走到该分支，证明上一个if分支不满足，即目标元素不等于低位元素
				if (target.hashCode() == intArray[upperBound].hashCode()) { // 等于高位元素，返回
					return upperBound;
				} else { // 高位元素也不等于目标元素，证明数组中没有该元素，搜索结束
					return -1;
				}
			} else {// 搜索段中的元素至少有三个，且当前元素不等于目标元素
				if (intArray[curIn].hashCode() < target.hashCode()) {
					// 如果当前元素小于目标元素，则将下一个搜索段的最小下标置为当前元素的下标
					lowerBound = curIn;
				} else {
					// 如果当前元素大于目标元素，则将下一个搜索段的最大下标置为当前元素的下标
					upperBound = curIn;
				}
			}
		}
	}

	// 插入
	public void insert(T elem) {
		int location = 0;

		// 判断应插入位置的下标
		for (; location < length; location++) {
			if (intArray[location].hashCode() > elem.hashCode())
				break;
		}
		// System.out.println(location);
		// 将插入下标之后的所有元素后移一位
		for (int i = length; i > location; i--) {
			intArray[i] = intArray[i - 1];
		}

		// 插入元素
		intArray[location] = elem;

		length++;
	}

	// 删除某个指定的元素值，删除成功则返回true，否则返回false
	public boolean delete(T target) {
		int index = -1;
		if ((index = find(target)) != -1) {
			for (int i = index; i < length - 1; i++) {
				// 删除元素之后的所有元素前移一位
				intArray[i] = intArray[i + 1];
			}
			length--;
			return true;
		} else {
			return false;
		}
	}

	// 列出所有元素
	public void display() {
		for (int i = 0; i < length; i++) {
			System.out.print(intArray[i] + "\t");
		}
		System.out.println();
	}

}
