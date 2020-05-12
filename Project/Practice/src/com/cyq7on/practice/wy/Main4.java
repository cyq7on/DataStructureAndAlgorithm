package com.cyq7on.practice.wy;


import java.util.ArrayList;
import java.util.List;

public class Main4 {
    private List<Integer> list = new ArrayList<>();

    /**
     *
     * @param boxes int整型二维数组
     * @return int整型
     */
    public int maxBoxes (int[][] boxes) {
        // write code here
        if (boxes == null) {
            return 0;
        }
        if (boxes.length <= 1) {
            return 1;
        }
        int max = 1;
        int k = 0;
        while (k < boxes.length - 1) {
            for (int i = k; i < boxes.length; i++) {
                for (int j = i + 1; j < boxes.length; j++) {
                    if (list.contains(j)) {
                        continue;
                    }
                    if (wrap(boxes[i], boxes[j])) {
                        list.add(j);
                        max++;
                    }
                }
            }
            k++;
        }

        return max;
    }

    private boolean wrap(int[] arr1,int[] arr2) {
        int[] diff = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            diff[i] = arr1[i] - arr2[i];
        }

        for (int i = 0; i < arr1.length; i++) {
            int count = 0;

            for (int j = 0; j < diff.length; j++) {
                if (diff[j] < 0) {
                    count ++;
                }
            }
            if (count == diff.length) {
                return true;
            }

            for (int j = 0; j < diff.length; j++) {
                if (diff[j] > 0) {
                    count ++;
                }
            }

            if (count == diff.length) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Main4 main4 = new Main4();
//        System.out.println(main4.maxBoxes(new int[][]{}));
//        System.out.println(main4.maxBoxes(new int[][]{{5,4,3}, {5,4,5}}));
//        System.out.println(main4.maxBoxes(new int[][]{{5,6,3}, {5,4,6}, {6,6,6}}));
        System.out.println(main4.maxBoxes(new int[][]{{5,4,3}, {5,4,5}, {6,6,6}}));
    }
}
