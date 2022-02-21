package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BTree<Integer> bTree = new BTree();

//        System.out.println(bTree.insert(1));
//        System.out.println(bTree.search(1));
//        System.out.println(bTree.search(2));
//        System.out.println(bTree.insert(1));

        System.out.println(bTree.insert(1));
        System.out.println(bTree.insert(2));
        System.out.println(bTree.insert(3));
        System.out.println(bTree.insert(4));
        System.out.println(bTree.search(4));
//        System.out.println(bTree.search(1));
//        System.out.println(bTree.insert(1));

//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        list.add("hi");

//        list.add(2, "gjf");
//        for (int i = 0; i < list.size(); ++i) {
//            System.out.println(list.get(i));
//        }
    }
}
