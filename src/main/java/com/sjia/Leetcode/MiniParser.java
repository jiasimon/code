package com.sjia.Leetcode;

import java.util.*;

public class MiniParser {
    // #385. Mini Parser    https://leetcode.com/problems/mini-parser/

    class NestedInteger {
        private Integer value;
        private List<NestedInteger> list;

        public NestedInteger() {
            list = new ArrayList<>();
        }

        public NestedInteger(int value) {
            this.value = value;
        }

        public boolean isInteger() {
            return value != null;
        }

        public Integer getInteger() {
            return value;
        }

        public void add(NestedInteger ni) {
            list.add(ni);
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }


    public NestedInteger deserialize(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        NestedInteger result = new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(result);
        int start = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                start = i + 1;
            } else if (c == ',' || c == ']') {
                if (i > start) {
                    int num = Integer.parseInt(s.substring(start, i));
                    stack.peek().add(new NestedInteger(num));
                }
                start = i + 1;
                if (c == ']') {
                    stack.pop();
                }
            }
        }

        return result;
    }


}
