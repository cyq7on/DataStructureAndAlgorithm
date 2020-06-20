package com.cyq7on.sword2offer.linklist;

import com.cyq7on.leetcode.linklist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
* @description
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/2/14
**/
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(size - 1 - i);
        }

        return arr;
    }

}
