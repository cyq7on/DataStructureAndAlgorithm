package com.cyq7on.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
* @description
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/8/20
**/
public class Combine {
    private List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, 1, new ArrayList<>());
        return lists;
    }

    private void combine(int n,int k,int start,List<Integer> list) {
        if (k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1 ; i++) {
            list.add(i);
            combine(n,k - 1,i + 1,list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4,2));
    }
}
