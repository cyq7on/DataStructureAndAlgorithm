package com.cyq7on.sword2offer.array;

import java.util.Arrays;
import java.util.Map;

/**
 * @author cyq7on
 * @description 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/17
 **/
public class MoveRange {

    public int movingCount(int m, int n, int k) {
        int[][] visit = new int[m][n];
        return movingCount(0, 0, k, visit);
    }

    private int movingCount(int i, int j, int k, int[][] visit) {
        if (i > visit.length - 1 || i < 0 || j > visit[0].length - 1 || j < 0 || visit[i][j] == 1 ||
                getDigitSum(i) + getDigitSum(j) > k) {
            return 0;
        }

        visit[i][j] = 1;

        return 1 + movingCount(i - 1, j, k, visit)
                + movingCount(i + 1, j, k, visit)
                + movingCount(i, j - 1, k, visit)
                + movingCount(i, j + 1, k, visit);
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MoveRange moveRange = new MoveRange();
        System.out.println(moveRange.movingCount(2, 3, 1));
        System.out.println(moveRange.movingCount(3, 1, 0));
    }
}
