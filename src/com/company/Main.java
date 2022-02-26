package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BTree<Integer> bTree = new BTree();


        System.out.println(bTree.insert(1));
        System.out.println(bTree.insert(100));
        System.out.println(bTree.insert(200));
        System.out.println(bTree.insert(50));
        System.out.println(bTree.insert(150));
        System.out.println(bTree.insert(60));
        System.out.println(bTree.insert(70));
        System.out.println(bTree.search(70));
    }
}
