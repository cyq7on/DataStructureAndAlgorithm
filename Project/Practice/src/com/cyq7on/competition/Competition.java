package com.cyq7on.competition;


public class Competition {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n - 1; i++) {
            sb.append("a");
        }
        //偶数
        if (n % 2 != 1) {
            sb.append("b");
        } else {
            sb.append("a");
        }
        return sb.toString();
    }

    public int numTimesAllBlue(int[] light) {
        int[] status = new int[light.length];
        int[] num = new int[light.length + 1];
        int notLight = 0;
//        num[0] = 1;
        int count = 0;
//        Arrays.fill(status, 0);
        for (int i = 0; i < light.length; i++) {
            int k = light[i];
//            status[k] = 1;
            /*if (k > 0) {
                num[k] = num[k - 1] + 1;
            }*/
            num[k] = num[k - 1] + 1;
            if (num[k] == i + 1) {
                count++;
            } else {
                notLight++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Competition competition = new Competition();
//        System.out.println(competition.numTimesAllBlue(new int[]{4, 1, 2, 3}));
        System.out.println(competition.numTimesAllBlue(new int[]{2, 1, 3, 5, 4}));
    }
}
