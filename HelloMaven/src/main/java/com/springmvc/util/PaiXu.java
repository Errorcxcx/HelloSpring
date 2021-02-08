package com.springmvc.util;

public class PaiXu {
    public static void main(String[] args) {
        int[] nums = {1,3,22,2,45,66,23,11};
        kuaisu(nums,0,7);
        System.out.println(nums[7]);
    }
    public static void charu(int[] nums){
        int preIndex;
        int current;
        for(int i = 1;i<nums.length;i++){
            current = nums[i];
            preIndex = i-1;
            while (preIndex>=0&&nums[i]<nums[preIndex]){
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = current;
        }
    }

    public static void kuaisu(int[] nums,int left,int right){
        int i = left;
        int j  = right;
        if(i>=j) return;
        int key = nums[left];
        while(i<j){
            while(i<j&&nums[j]>=key){
                j--;
            }
            if(i<j){
                nums[i] = nums[j];
                i++;
            }
            while(i<j&&nums[i]<key){
                i++;
            }
            if(i<j){
                nums[j] = nums[i];
                j--;
            }
            nums[i] = key;
            kuaisu(nums,left,i-1);
            kuaisu(nums,i+1,right);
        }
    }

}
