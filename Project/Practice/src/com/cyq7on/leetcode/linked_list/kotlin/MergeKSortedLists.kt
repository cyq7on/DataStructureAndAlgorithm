package com.cyq7on.leetcode.linked_list.kotlin


class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode>): ListNode {
        return lists[0]
    }
}

fun main() {
    val mergeKSortedLists = MergeKSortedLists()

    val listNode1 = ListNode(intArrayOf(1, 4, 5))
    val listNode2 = ListNode(intArrayOf(1, 3, 4))
    val listNode3 = ListNode(intArrayOf(2, 6))
    val lists = arrayOf(listNode1, listNode2, listNode3)
    println(mergeKSortedLists.mergeKLists(lists))
}
