package com.sf.wdx.tree;

/**
 * 描述：树节点的封装类 树：路径、根、父节点、子节点、叶节点、子树、层
 * 		如果树的每个节点最多有两个子节点，则称为二叉树。如果节点的子节点可以多余两个，称为多路树。从树的根到任意节点有且只有一条路径可以到达。
 * 		二叉搜索树：一个节点的左子节点的关键字值小于这个节点，右子节点的关键字值大于或等于这个父节点。 
 * 		平衡树与非平衡树：非平衡就是说树的大部分节点在根的一边。
 * 		有三种简单的方法遍历树：前序遍历、中序遍历、后序遍历（看本节点的顺序在前or中or后）
 * 		中序遍历：1、调用自身来遍历节点的左子树    2、访问这个节点    3、调用自身来遍历节点的右子树
 * @author 80002888
 * @date 2018年10月15日
 */
public class Node {
    int age;
    String name;
    Node leftChild;  //左子节点的引用
    Node rightChild; //右子节点的引用
   
    public Node(int age,String name){
           this.age = age;
           this.name = name;
    }
   
    //打印该节点的信息
    public void displayNode(){
           System.out.println("name:"+name+",age:"+age);
    }
}

