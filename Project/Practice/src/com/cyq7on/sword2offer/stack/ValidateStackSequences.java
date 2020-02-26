package com.cyq7on.sword2offer.stack;


import java.util.Stack;

/**
 * @author cyq7on
 * @description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 * 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/24
 **/
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        int index1, index2 = 0;
        Stack<Integer> stack = new Stack<>();
        for (index1 = 0; index1 < pushed.length; index1++) {
            stack.push(pushed[index1]);
            while (!stack.isEmpty() && stack.peek() == popped[index2]) {
                stack.pop();
                index2++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        System.out.println(validateStackSequences.validateStackSequences(new int[]{0, 2, 1},
                new int[]{0, 1, 2}));
        System.out.println(validateStackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 3, 2, 1}));
        System.out.println(validateStackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2}));
    }
}
