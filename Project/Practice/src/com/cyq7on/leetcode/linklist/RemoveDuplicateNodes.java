package com.cyq7on.leetcode.linklist;

import java.util.HashSet;
import java.util.Set;

/**
* @description
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/6/26
**/
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        set.add(cur.val);
        while (cur != null && cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            }else {
                set.add(cur.next.val);
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicateNodes removeDuplicateNodes = new RemoveDuplicateNodes();
        System.out.println(removeDuplicateNodes.removeDuplicateNodes(new ListNode(new int[] {1, 2, 3, 3, 2, 1})));
    }
}
