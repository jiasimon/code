package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    // #22 https://leetcode.com/problems/generate-parentheses/submissions/

    // Runtime: 3 ms, faster than 28.99% of Java online submissions for Generate Parentheses.
    //Memory Usage: 40.9 MB, less than 12.20% of Java online submissions for Generate Parentheses.

    // use if (left > right || left < 0 || right < 0), remove condition before recursive call
    // Runtime: 1 ms, faster than 86.83% of Java online submissions for Generate Parentheses.
    // Memory Usage: 39.3 MB, less than 88.90% of Java online submissions for Generate Parentheses.


    static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        if (n ==1)  {
            res.add("()");
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    static void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与 第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right || left < 0 || right < 0) {
            return;
        }
            dfs(curStr + "(", left - 1, right, res);
            dfs(curStr + ")", left, right - 1, res);
    }

    public static void main(String[] args) {
        int testData  = 3;
        List<String> result = generateParenthesis(testData);
        System.out.printf(" Number %d  Generate Parentheses is: %s \n", testData, result);
    }


}
