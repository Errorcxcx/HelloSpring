package com.myinterview.test;

public class Test {
    public static void main(String[] args) {
//        test_01_moertoupiao();
//        test_02_maopao();
//        test_03_erfen();
//        test_04_xuanzepaixu();
//        test_05_charupaixu();
        test_06_xierpaixu();
    }


    public static void test_01_moertoupiao() {
        int[] nums = new int[]{1, 2, 2, 3, 3, 4, 2, 3, 3, 3, 3};
        int first = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                times = 1;
                first = nums[i];
                continue;
            }
            if (first != nums[i]) {
                times--;
            } else {
                times++;
            }
        }
        System.out.println(times);
        System.out.println(first);
    }

    public static void test_02_maopao() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                int temp;
                if (nums[j] < nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(nums[1]);
    }

    public static void test_03_erfen() {
        int[] nums = {1, 4, 11, 22, 33, 44, 55, 66, 77, 88, 99, 123};
        int middle = nums.length / 2;
        int target = 1;
        int head = 0;
        int foot = nums.length;
        while (head <= foot) {
            if (nums[middle] == target) {
                System.out.println("存在");
                return;
            } else if (nums[middle] < target) {
                head = middle + 1;
            } else if (nums[middle] > target) {
                foot = middle - 1;
            }
            middle = (head + foot) / 2;

        }
        System.out.println("不存在");
    }

    public static void test_04_xuanzepaixu() {
        int[] nums = {1, 4, 11, 22, 33, 44, 55, 66, 77, 88, 99, 123};
        int maxIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[maxIndex] < nums[j]) {
                    maxIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
        System.out.println(nums[0]);
        System.out.println(nums[nums.length - 1]);

    }

    public static void test_05_charupaixu() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int preIndex;
        int current;
        for (int i = 1; i < nums.length; i++) {
            preIndex = i - 1;
            current = nums[i];
            while (preIndex >= 0 && nums[preIndex] < current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;

        }
        System.out.println(nums[0]);
        System.out.println(nums[nums.length - 1]);

    }

    public static void test_06_xierpaixu() {
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        int grep;
        int temp;
        for(grep = nums.length/2;grep>=1;grep= grep/2){
            for(int j = grep;j<nums.length;j++){
                temp = nums[j];
                while((j-grep)>=0&&nums[j-grep]<temp){
                    nums[j] = nums[j-grep];
                    j = j-grep;
                }
                nums[j] = temp;

            }
        }
        System.out.println(nums[0]);
        System.out.println(nums[nums.length-1]);
    }
}
