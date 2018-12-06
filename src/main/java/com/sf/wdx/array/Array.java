package com.sf.wdx.array;

/**
 * 描述：无序数组
 *		无序数组的优点：插入快，如果知道下标，可以很快的存取
 *		无序数组的缺点：查找慢，删除慢，大小固定。
 * @author 80002888
 * @date   2018年10月8日
 */
public class Array<T> {
	
	public static void main(String[] args) {
		Array<String> array = new Array<>(5);
		array.insert("A");
		array.insert("B");
		array.insert("A");
		array.insert("A");
		array.display();
		
		System.out.println(array.contains("A"));
		System.out.println(array.contains("C"));
		
		array.delete("A");
		array.display();
	}

	private T[] strArray;
	private int length = 0; // 数组元素个数

	// 构造方法，传入数组最大长度
	@SuppressWarnings("unchecked")
	public Array(int max) {
		strArray = (T[])new Object[max];
	}

	// 检测数组是否包含某个元素，如果存在返回其下标，不存在则返回-1
	public int contains(T target) {
		int index = -1;
		for (int i = 0; i < length; i++) {
			if (strArray[i].equals(target)) {
				index = i;
				break;
			}
		}
		return index;
	}

	// 插入
	public void insert(T elem) {
		strArray[length] = elem;
		length++;
	}

	// 删除某个指定的元素值，删除成功则返回true，否则返回false
	public boolean delete(T target) {
		int index = -1;
		if ((index = contains(target)) != -1) {
			for (int i = index; i < length - 1; i++) {
				// 删除元素之后的所有元素前移一位
				strArray[i] = strArray[i + 1];
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
			System.out.print(strArray[i] + "\t");
		}
		System.out.println();
	}

}
