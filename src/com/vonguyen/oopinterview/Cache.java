package com.vonguyen.oopinterview;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    class Node {
        public Object key;
        public Object value;
        public Node left;
        public Node right;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    //pointer to the elements
    private Map<Object, Node> map = new HashMap();
    private Node head;
    private Node tail;
    int maxCapacity;
    int capacity;

    public Cache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        capacity = 0;
    }

    private void removeHead() {
        Node temp = head;
        head = head.right;
        head.left = null;
        temp.left = temp.right = null;
    }

    private void addTail(Node node) {
        node.left = tail;
        tail.right = node;
        node.right = null;
        tail = node;
    }

    public void put(Object key, Object value) {
        Node node = new Node(key, value);
        if (capacity == 0) {
            head = tail = node;
            capacity++;
        } else {
            Node curr = map.get(key);
            if (curr != null) {
                curr.value = value;
                get(key);
            } else {
                // add to tail
                addTail(node);
                if (capacity == maxCapacity) {
                    //remove head
                    removeHead();
                } else {
                    capacity++;
                }
            }
        }
        map.put(key, node);
    }

    public Object get(Object key) {
        Node node = map.get(key);
        Object ret = node.value;
        if (node == null) {
            return null;
        }
        if (capacity > 1) {
            if (node.left != null && node.right != null) {
                Node left = node.left;
                Node right = node.right;
                left.right = right;
                right.left = left;
                addTail(node);
            } else if (node.left == null) { //head
                removeHead();
                addTail(node);
            }
        }
        return ret;
    }

    public void print() {
        System.out.print("List from left to right: ");
        Node curr = head;
        while (curr != null) {
            System.out.print("(" + curr.key.toString() + ":" + curr.value.toString() + ") ");
            curr = curr.right;
        }
        System.out.println();

        System.out.print("Map: ");
        map.forEach((k,v) -> System.out.print("(" + k.toString() + ":(" + v.key.toString() + "," + v.value.toString() + ")) "));
        System.out.println();
    }

    public static void main(String[] args) {
        Cache cache = new Cache(3);
        cache.put(1, "A");
        cache.print();
        cache.put(2, "B");
        cache.print();
        cache.put(3, "C");
        cache.print();
        cache.put(1, "D");
        cache.print();
    }
}
