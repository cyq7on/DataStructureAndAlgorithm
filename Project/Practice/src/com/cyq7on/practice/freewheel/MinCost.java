package com.cyq7on.practice.freewheel;

import java.util.Arrays;

public class MinCost {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型 视频长度
     * @param cuePoints int整型一维数组 cue points列表
     * @return int整型
     */
    public int minCost (int n, int[] cuePoints) {
        // write code here
        Arrays.sort(cuePoints);
        int val = n / 2;
        int mid = cuePoints[0];
        int diff = Math.abs(val - mid);
        for (int i : cuePoints) {
            int abs = Math.abs(i - val);
            if (diff > abs) {
                diff = abs;
                mid = i;
            }
        }

        int res = n;
        for (int i = cuePoints.length - 1;i >= 0;i--) {
            if (cuePoints[i] == mid) {
                continue;
            }
            if (cuePoints[i] > mid) {
                res += n - mid - cuePoints[i];
            }else {
                res += mid - cuePoints[i];
            }
        }
        return -1;
    }
}
