package com.cyq7on.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
* @description
 * 定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/8/20
**/
public class Permute {
    private List<List<Integer>> lists = new ArrayList<>();
    private boolean[] visit;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        this.visit = new boolean[nums.length];
        permute(nums,new ArrayList<>());
        return lists;
    }

    //基于visit数组，还可以基于交换来实现
    //https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-ji-yu-jiao-huan-he-used-shu-zu-de-lia/
    private void permute(int[] nums,List<Integer> list) {
        if (nums.length == list.size()) {
            lists.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            permute(nums, list);
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1,2,3}));
    }
}
