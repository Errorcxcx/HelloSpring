package com.cx;

public class test {
    public static void main(String[] args) {
        moer();
        xier();
        charu();
    }

    public static void charu() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int pre = i - 1;
            while (pre >= 0 && target > nums[pre]) {
                nums[pre + 1] = nums[pre];
                pre = pre - 1;
            }
            nums[pre + 1] = target;
        }
        System.out.println(nums[0]+"==="+nums[7]);

    }

    public static void xier() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int grep = nums.length / 2; grep > 0; grep = grep / 2) {
            for (int i = grep; i < nums.length; i++) {
                int j = i;
                int current = nums[i];
                while (j - grep >= 0 && current > nums[j - grep]) {
                    nums[j] = nums[j - grep];
                    j = j - grep;
                }
                nums[j] = current;
            }

        }
        System.out.println(nums[0]+"==="+nums[7]);
    }

    public static void moer() {
        int[] nums = {1, 1, 1, 1, 2, 2, 2};
        int num = 1;
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num == 0) {
                first = nums[i];
                continue;
            }
            if (first == nums[i]) {
                num++;
            } else {
                num--;
            }
        }
        System.out.println(first + "---" + num);
    }
}

