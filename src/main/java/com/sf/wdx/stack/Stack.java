package com.sf.wdx.stack;

/**
 * 描述：栈是一种“后进先出”的数据结构 栈最基本的操作是出栈（Pop）、入栈（Push）
 * 		栈和队列是比数组和其他数据结构更加抽象的结构，是站在更高的层面对数据进行组织和维护
 * @author 80002888
 * @date 2018年10月8日
 */
public class Stack<T> {

	public static void main(String[] args) {
		// 利用栈完成检验括号的方法
		String str = "a{b(c[d]e)f}";
		Stack<Character> stack = new Stack<>(str.length());
		
		for (int i = 0; i < str.length(); i++) {
			// 获取字符串中的单个字符
			char ch = str.charAt(i);
			// 如果为左分隔符，压入栈
			if (ch == '{' || ch == '(' || ch == '[') {
				stack.push(ch);
			}
			// 如果为右分隔符，与栈顶元素进行匹配
			if (ch == '}' || ch == ')' || ch == ']') {
				if (!stack.isEmpty()) {
					// 获取栈顶元素
					char chx = stack.pop();
					if ((chx == '{' && ch != '}') || (chx == '(' && ch != ')') || (chx == '[' && ch != ']')) {
						System.out.println("匹配出错！字符：" + ch + ",下标：" + i);
					}
				} else {
					System.out.println("匹配出错！字符：" + ch + ",下标：" + i);
				}
			}
		}

		// 匹配结束时如果栈中还有元素，证明右分隔符缺失
		if (!stack.isEmpty()) {
			System.out.print("有括号没有关闭！");
			stack.display();
		}

	}

	private int size; // 栈的大小
	private int top; // 栈顶元素的下标
	private T[] stackArray; // 栈的容器

	// 构造函数
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		stackArray = (T[]) new Object[size];
		top = -1; // 初始化栈的时候，栈内无元素，栈顶下标设为-1
		this.size = size;
	}

	// 入栈，同时，栈顶元素的下标加一
	public void push(T elem) {
		stackArray[++top] = elem; // 插入栈顶
	}

	// 出栈，删除栈顶元素，同时，栈顶元素的下标减一
	public T pop() {
		return stackArray[top--];
	}

	// 查看栈顶元素，但不删除
	public T peek() {
		return stackArray[top];
	}

	// 判空
	public boolean isEmpty() {
		return (top == -1);
	}

	// 判满
	public boolean isFull() {
		return (top == size - 1);
	}

	// 打印
	public void display(){
		for (int i = 0; i <= top; i++) {
			System.out.print(stackArray[i] + "\t");
		}
		System.out.println();
	}
	
}
