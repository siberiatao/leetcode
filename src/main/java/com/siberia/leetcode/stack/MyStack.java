package com.siberia.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 双队列，实现栈
 */
public class MyStack {
    Queue<Integer> first;
    Queue<Integer> second;

    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    public void push(int x) {
        first.offer(x);
    }

    public int pop() {
        if (first.size() == 1) {
            return first.poll();
        }
        int result;
        while (first.size() != 1) {
            second.offer(first.poll());
        }
        result = first.poll();
        while (!second.isEmpty()) {
            first.offer(second.poll());
        }
        return result;
    }

    public int top() {
        if (first.size() == 1) {
            return first.peek();
        }
        int result;
        while (first.size() != 1) {
            second.offer(first.poll());
        }
        result = first.peek();
        second.offer(first.poll());
        while (!second.isEmpty()) {
            first.offer(second.poll());
        }
        return result;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
