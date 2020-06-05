package com.cyq7on.sword2offer.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyq7on
 * @description 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/24
 **/
public class SpiralMatrix {
    /**
     * 核心思想就是确定矩阵的四个顶点，然后顺时针进行添加。需要注意的有2点：
     * 1. 不要重复添加四个顶点的元素
     * 2. 如果只有一行或者一列元素，不要再进入for循环进行添加
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>(0);
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            if (--bottom < top) {
                break;
            }

            for (int i = bottom; i > left; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return list;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        int cols = matrix.length;
        if (cols == 0) {
            return new ArrayList<>(0);
        }
        int rows = matrix[0].length;
        if (rows == 0) {
            return new ArrayList<>(0);
        }
        int left = 0;
        int right = rows - 1;
        int top = 0;
        int bottom = cols - 1;
        List<Integer> list = new ArrayList<>(rows * cols);
        while (left <= right && top <= bottom) {
            int i;
            for (i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }

            for (i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            //只有一行的情况则不再遍历
            if (top != bottom) {
                for (i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            //只有一列的情况则不再遍历
            if (left != right) {
                for (i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }
}
