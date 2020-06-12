package com.cyq7on.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
* @description
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/6/8
**/
public class EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            String[] split = equation.split("(==|!=)");
            boolean equals = equation.contains("==");
            if (split[0].equals(split[1])) {
                if (equals) {
                    continue;
                }else {
                    return false;
                }
            }
            Integer left = map.get(split[0]);
            Integer right = map.get(split[1]);
            if (left == null && right == null) {
                if (equals) {
                    map.put(split[0], i);
                    map.put(split[1], i);
                }else {
                    map.put(split[0], i);
                    map.put(split[1], i + 1);
                }
            }else if (left == null) {
                if (equals) {
                    map.put(split[0], right);
                }else {
                    map.put(split[0], right + 1);
                }
            }else if (right == null){
                if (equals) {
                    map.put(split[1], left);
                }else {
                    map.put(split[1], left + 1);
                }
            }else {
                if (equals) {
                    if (!left.equals(right)) {
                        return false;
                    }
                }else {
                    if (left.equals(right)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Boolean.parseBoolean("a==b"));
        System.out.println(Boolean.parseBoolean("1==2"));
        System.out.println(Boolean.parseBoolean("1!=2"));
        EquationsPossible equationsPossible = new EquationsPossible();
        System.out.println(equationsPossible.equationsPossible(new String[]{"e==d","e==a","f!=d","b!=c","a==b"}));
        System.out.println(equationsPossible.equationsPossible(new String[]{"f==b","c==b","c==b","e!=f"}));
        System.out.println(equationsPossible.equationsPossible(new String[]{"a==b","b!=a"}));
        System.out.println(equationsPossible.equationsPossible(new String[]{"c==c","f!=a","f==b","b==c"}));
        System.out.println(equationsPossible.equationsPossible(new String[]{"b==b","b==e","e==c","d!=e"}));
    }
}
