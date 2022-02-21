package com.company;

import java.util.ArrayList;
import java.util.List;

public class BTree<T extends Comparable<T>> {
    // The degree of the B-Tree
    private static int t = 2;
    private static final int minKeys = t - 1;
    private static final int maxKeys = 2 * t - 1;
    private static final int minChildren = minKeys + 1;
    private static final int maxChildren = maxKeys + 1;

    public BTree() {
        root = new BNode<>();
    }

    // The node of the B-Tree
    private class BNode<E extends Comparable<E>> {
        public BNode() {
            isLeaf = true;
            keyNum = 0;
            keys = new ArrayList<>();
            children = new ArrayList<>();
        }

        private boolean isLeaf;
        private int keyNum;
        private List<E> keys;
        private List<BNode<E>> children;
    }

    private BNode<T> root;

    public boolean search(T value) {
        return search(root, value);
    }

    private boolean search(BNode<T> root, T value) {

        int index = 0;
        while (index < root.keyNum && value.compareTo(root.keys.get(index)) > 0)
            ++index;

        if (index < root.keyNum && value.compareTo(root.keys.get(index)) == 0) {
            return true;
        }

        if (root.isLeaf) {
            return false;
        }

        if (root.children.get(index) == null) {
            root.children.set(index, new BNode<>());
        }
        return search(root.children.get(index), value);

    }

    /***
     * insert a value into the B-Tree
     * @param value
     * @return
     */
    public boolean insert(T value) {
        // check if the B-Tree already has the value before inserting
        if (search(value)) {
            return false;
        }

        if (root.keyNum == maxKeys) {

            BNode<T> newRoot = new BNode<>();
            newRoot.isLeaf = false;
            newRoot.children.add(root);
            split(newRoot, 0);
            root = newRoot;
//            System.out.println(root.keyNum);
//            System.out.println(root.keys.get(0));
//            System.out.println(root.children.get(1).keys.get(0));
        }
        insert_node(root, value);
        return true;
//        return insert(root, value);
    }


    /***
     * split the index child node of node
     * note: not node, but its child !!!
     * @param node
     * @param index
     */
    private void split(BNode<T> node, int index) {
        BNode<T> rightChild = new BNode<>();
        BNode<T> leftChild = node.children.get(index);
        rightChild.isLeaf = leftChild.isLeaf;
        rightChild.keyNum = minKeys;

        for (int i = 0; i < t - 1; ++i) {
            rightChild.keys.add(leftChild.keys.get(i + t));
        }

        if (!rightChild.isLeaf) {
            for (int i = 0; i < t - 1; ++i) {
                rightChild.children.add(leftChild.children.get(i + t));
            }
        }

        leftChild.keyNum = minKeys;

        node.children.add(index + 1, rightChild);
        node.keys.add(index, leftChild.keys.get(t-1));
        ++node.keyNum;
    }
    /***
     * the root is not null
     * @param root
     * @param value
     * @return
     */
    private boolean insert(BNode<T> root, T value) {
        if (root.keyNum == maxKeys) {
//            BNode<T>
        }

        int index = 0;
        // keys: 0 ~ keyNum - 1
        // values: 0 ~ keyNum
        // index: 0 ~ keyNum
        while (index < root.keyNum && value.compareTo(root.keys.get(index)) < 0) {
            index++;
        }

        // the node needs to be split before inserting a value
        if (root.keyNum == maxKeys) {

        } else {

        }
        if (root.children.get(index) == null) {

        } else {
            insert(root.children.get(index), value);
        }

        return true;
    }

    private void insert_node(BNode<T> root, T value) {
        int index = root.keyNum;

        // leaf node
        if (root.isLeaf) {
            // find the position to insert the value
            // position i: keys[i-1] < value < keys[i]
            while (index > 0 && value.compareTo(root.keys.get(index - 1)) < 0)
                --index;
            root.keys.add(index, value);
            ++root.keyNum;
            return;
        }

        // inner node
        while (index > 0 && value.compareTo(root.keys.get(index - 1)) < 0)
            --index;

        if (root.keyNum == maxKeys) {
            split(root, index);
        }

        insert_node(root.children.get(index), value);
    }
}