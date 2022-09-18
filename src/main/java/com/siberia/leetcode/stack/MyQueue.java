package com.siberia.leetcode.stack;

import java.util.List;
import java.util.Stack;

/**
 * 双栈实现先入先出队列
 */
public class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        second.clear();
        int result;
        while (!first.empty()) {
            second.push(first.pop());
        }
        result = second.pop();
        while (!second.empty()) {
            first.push(second.pop());
        }
        return result;
    }

    public int peek() {
        int result = pop();
        first.push(result);
        return result;
    }

    public boolean empty() {
        return first.empty();
    }
}
