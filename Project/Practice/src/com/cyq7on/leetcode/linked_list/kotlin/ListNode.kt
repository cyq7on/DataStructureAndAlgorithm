package com.cyq7on.leetcode.linked_list.kotlin

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    constructor(arr:IntArray) : this(arr[0]) {
        var cur:ListNode ? = this
        for (i in arr) {
            cur?.next = ListNode(i)
            cur = cur?.next
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var cur: ListNode? = this
        while (cur != null) {
            sb.append(cur.`val`).append("->")
            cur = cur.next
        }
        sb.append("null")
        return sb.toString()
    }
}