package com.cx;

import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestPing {
    public static void main(String[] args) throws InterruptedException {
//        Jedis jedis =new Jedis("localhost",6379);
//        String result = jedis.ping();
//        System.out.println(result);
        ExecutorService executorService = Executors.newCachedThreadPool();
//        for(int i = 0;i<10;i++){
//            final int index = i;
//            System.out.println("执行了");
//
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(index+"--"+Thread.currentThread().getName());
//                        Thread.sleep(2000);
//
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            });
//            System.out.println("执行完了");
//
//        }
//        System.out.println(get("1AB2345CD", "12345EF"));
//        System.out.println(qudiaoQQ("hahahaha123456789ssdsd456789123"));
//        StringBuilder stringBuilder = new StringBuilder("sdsdsdsdsdsdsv");
//        stringBuilder.delete(0,stringBuilder.length());
//        System.out.println(stringBuilder.toString());

//        System.out.println(LCS("abcdefgh", "npcdehmv"));
//        System.out.println("123456".substring(6,6));
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("s");
//        String str1 = "12345";
//        String str2 = "12345";
//        String str3 = new String("12345");
//        str1 = str1 + "sdsds";
//        System.out.println(str1.hashCode());
//        System.out.println(str2.hashCode());
//        System.out.println(str3 == str2);

//        test(1,null,null);
//        int[] A = {1};
//        int[] B = {2};
//        merge(A,1,B,1);
//        test("sss");
        int[] nums = {2, 2, 3, 4, 5, 6, 3};

        String tr = "abcddefghinc";
        System.out.println(test2(nums));
    }

    //数组中连续最长子串[2,2,3,4,3]
    public static int test2(int[] arr) {
        int start = 0;
        int now =0;
        int res = 0;
        int[] hash = new int[100000];
        for(int i = 0;i<arr.length;i++){
            now = arr[i];
            start = Math.max(start,hash[now]);
            res = Math.max(res,i-start+1);
            hash[now] = i+1;
        }
        return res;
    }

    //最长连续不含相同字符子串   abcddefghigc
    public static int test3(String str) {
        int max = 0;
        int index = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((index = builder.toString().indexOf(str.charAt(i))) != -1) {
                builder.append(str.charAt(i));
                builder.delete(0, index + 1);
            } else {
                builder.append(str.charAt(i));
                max = Math.max(builder.length(), max);
            }
        }
        return max;
    }


    //数组中连续最长子串[2,2,3,4,3]
    public static int test1(int[] arr) {
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();
        int res = 1;
        while (right < arr.length) {
            if (!set.contains(arr[right])) {
                set.add(arr[right]);
                right++;
            } else {
                set.remove(arr[left]);
                left++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    //张三，李四，王五，郑六
    public static void test(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        String string = "张三，李四，王五，郑六啊";

        for (int i = string.length() - 1; i >= 0; i--) {
            stringBuilder.append(string.charAt(i));
            System.out.println(stringBuilder.toString());
        }
        System.out.println(stringBuilder.toString());

    }

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
    }


    public static void merge(int A[], int m, int B[], int n) {
        if (m == 0) {
            for (int i = 0; i < B.length; i++) {
                A[i] = B[i];
            }
        } else {
            for (int i = 0; i < B.length; i++) {
                int current = B[i];
                int preindex = m - 1 + i;
                while (preindex >= 0 && A[preindex] > current) {
                    A[preindex + 1] = A[preindex];
                    preindex--;
                }
                A[preindex + 1] = current;
            }
        }
        for (int i : A) {
            System.out.println(i);
        }

    }

    public static String get(String str1, String str2) {
        int row = 0;
        int col = str2.length() - 1;
        int i;
        int j;
        int len = 0;
        int max = 0;
        StringBuilder str = new StringBuilder();
        String result = null;
        while (row < str1.length()) {
            i = row;
            j = col;
            while (i < str1.length() && j < str2.length()) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    str.append(str1.charAt(i));
                } else {
                    if (str.length() > max) {
                        result = str.toString();
                        max = str.length();
                        str.delete(0, str.length());
                    }
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        if (max == 0) {
            return "-1";
        }
        return result;
    }

    //去掉消息中6-10位的qq号
    public static String qudiaoQQ(String content) {
        StringBuilder str = new StringBuilder();
        String result = content;
        for (int i = 0; i < content.length(); i++) {
            if (Character.isDigit(content.charAt(i))) {
                str.append(content.charAt(i));
                if (i == content.length() - 1 && str.length() >= 6 && str.length() <= 10) {
                    result = result.replace(new String(str), "");
                }
            } else {
                if (str.length() >= 6 && str.length() <= 10) {
                    result = result.replace(new String(str), "");
                }
                str.delete(0, str.length());

            }
        }
        return result;

    }

    //两个字符串的最大公共子串
    public static String LCS(String str1, String str2) {
        StringBuilder str = new StringBuilder();
        int start = 0;
        int end = 1;
        while (end < str1.length() + 1) {
            if (str2.contains(str1.substring(start, end))) {
                if (str.length() < end - start) {
                    str.delete(0, str.length());
                    str.append(str1.substring(start, end));
                }
                end++;
            } else {
                start++;
            }
        }
        return str.length() > 0 ? str.toString() : "-1";
    }

    //两个字符串的最大公共子串
    public String LCS1(String str1, String str2) {
        // write code here
        int row = 0;
        int col = str2.length() - 1;
        int i;
        int j;
        int max = 0;
        String str = "";
        String result = null;
        while (row < str1.length()) {
            i = row;
            j = col;
            while (i < str1.length() && j < str2.length()) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    str += str1.charAt(i);
                } else {
                    if (str.length() > max) {
                        result = str;
                        max = str.length();
                    }
                    str = "";
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        if (result.length() == 0) {
            return "-1";
        }
        return result;
    }

    //两个有序数组合并找TOP K
    public static void test(int k, int[] nums1, int[] nums2) {
        int[] shuzu1 = {1, 2, 3, 4, 5, 6};
        int[] shuzu2 = {3, 4, 5, 6, 7, 8};
        int[] hebing = new int[12];
        for (int i = 0; i < shuzu1.length; i++) {
            hebing[i] = shuzu1[i];
        }
        for (int i = 0; i < shuzu2.length; i++) {
            int current = shuzu2[i];
            int preindex = shuzu1.length - 1 + i;
            while (preindex >= 0 && hebing[preindex] > current) {
                hebing[preindex + 1] = hebing[preindex];
                preindex--;
            }
            hebing[preindex + 1] = current;
        }
        for (int i = 0; i < hebing.length; i++) {
            System.out.println(hebing[i]);
        }
    }


}
