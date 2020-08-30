package com.cyq7on.practice.other;


public class Group {

    public static int countGroupAgeMoreThanHalf(int[] groupAges) {
        if(groupAges == null || groupAges.length == 0) {
            return 0;
        }
        int count = 1;
        int num = groupAges[0];
        for(int i = 1;i < groupAges.length;i++) {
            if(count == 0) {
                num = groupAges[i];
            }
            if(num == groupAges[i]) {
                count++;
            }else {
                count--;
            }
        }
        //检验
        count = 0;
        for(int i = 0;i < groupAges.length;i++){
            if(groupAges[i] == num) {
                count++;
            }
        }
        return count > groupAges.length / 2 ? num : 0;
    }

    public static void main(String[] args) {
        System.out.println(countGroupAgeMoreThanHalf(new int[]{23, 22, 23, 24, 23}));
    }
}
