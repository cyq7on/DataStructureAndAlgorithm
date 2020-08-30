package com.cyq7on.practice.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tiger {

    int[] arr;
    char[] op;

    int max[];//max[i]表示从i到末尾表达式的最大值
    int suffix[];//min[i]表示从i到末尾表达式的最小值

    //压缩正号
    private void compress() {
        int i = 0;
        arr = Arrays.copyOf(this.arr, this.arr.length);
        op = Arrays.copyOf(this.op, this.op.length);
        for (int j = 1; j < arr.length; j++) {
            if (op[i] == '+' && op[j] == '+') {
                arr[i] += arr[j];
            } else {
                i++;
                op[i] = op[j];
                arr[i] = arr[j];
            }
        }
        arr = Arrays.copyOf(arr, i + 1);
        op = Arrays.copyOf(op, i + 1);
    }


    public int getMaxResult(String expression) {

        List<Integer> num = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
//                arr[k++] = ch - '0';
                num.add(ch - '0');
            }else {
//                op[j++] = ch;
                ops.add(ch);
            }
        }

        arr = new int[num.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = num.get(i);
        }

        if (ops.size() != num.size()) {
            op = new char[ops.size() + 1];
            for (int i = 1; i < op.length; i++) {
                op[i] = ops.get(i - 1);
            }
            op[0] = '+';
        }else {
            op = new char[ops.size()];
            for (int i = 0; i < op.length; i++) {
                op[i] = ops.get(i);
            }
        }

        compress();
        max = new int[arr.length];
        suffix = new int[arr.length];
        suffix[suffix.length - 1] = arr[suffix.length - 1];
        for (int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = arr[i] + suffix[i + 1];
        }
        max[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (op[i + 1] == '+') {
                max[i] = max[i + 1] + arr[i];
            } else {
                if (i + 2 >= arr.length) {
                    max[i] = arr[i] - arr[i + 1];
                    continue;
                }
                if (op[i + 2] == '-') {//连续两个减号
                    max[i] = arr[i] - arr[i + 1] + suffix[i + 2];
                } else {//-+-
                    //一括到底
                    int s = arr[i] - arr[i + 1] - arr[i + 2] + (i + 3 < suffix.length ? suffix[i + 3] : 0);
                    //只扩一个
                    int ss = arr[i] - arr[i + 1] + max[i + 2];
                    max[i] = Math.max(s, ss);
                }
            }
        }
        return max[0];
    }

    String tos() {
        StringBuilder builder = new StringBuilder();
        builder.append(arr[0]);
        for (int j = 1; j < arr.length; j++) {
            builder.append(op[j]).append(arr[j]);
        }
        return builder.toString();
    }
    /**
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray (int[] array) {

        int m = array.length;
        int k = 0;
        for (int i = 0; i < m; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j > k) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                k++;
            }
        }
        return array;
    }

    public int[] exchange(int[] nums) {
        int slow = 0,fast = 0;
        while(fast<nums.length){
            if((nums[fast]&1)==1) swap(nums,slow++,fast);
            fast++;
        }
        return nums;
    }

    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] =temp;
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        System.out.println(tiger.getMaxResult("1-2-3+4"));
        System.out.println(Arrays.toString(tiger.reOrderArray(new int[]{-4,1,2,3,4})));
    }
}
