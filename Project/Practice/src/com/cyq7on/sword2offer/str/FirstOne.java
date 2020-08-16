package com.cyq7on.sword2offer.str;

public class FirstOne {
    private int[] arr = new int[256];
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        arr[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i = 0;i < arr.length;i++) {
            if(arr[i] == 1) {
                return (char)i;
            }
        }
        return '#';
    }
}
