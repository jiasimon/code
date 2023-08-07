package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {
    // #341. Flatten Nested List Iterator   https://leetcode.com/problems/flatten-nested-list-iterator/description/
    /*
    You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

    Implement the NestedIterator class:

    NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
    int next() Returns the next integer in the nested list.
    boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
     */

    interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        Deque<Integer> queue = new ArrayDeque<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            dfs(nestedList);
        }

        @Override
        public Integer next() {
            return hasNext() ? queue.pollFirst() : -1;

        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();

        }

        void dfs(List<NestedInteger> list) {
            for (NestedInteger item : list) {
                if (item.isInteger()) {
                    queue.addLast(item.getInteger());
                } else {
                    dfs(item.getList());
                }
            }
        }


    }
}
