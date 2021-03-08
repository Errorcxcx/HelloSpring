package com.springmvc;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ali {
    /**
     * 初始化未来三天的销量
     */
    public static Map<Date, Double> initSalesPlanMap() {
        Map<Date, Double> salesPlanMap = new HashMap<>();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        long dayTime = calendar.getTime().getTime();
        long now = System.currentTimeMillis() / 1000l;
        long daySecond = 60 * 60 * 24;
        long dayTime = now - (now + 8 * 3600) % daySecond;
        //今天的销量计划-10
        salesPlanMap.put(new Date(dayTime * 1000), 10.00);
        //明天的销量计划-20
        salesPlanMap.put(new Date((dayTime + 24 * 3600) * 1000), 20.00);
        //后台的销量计划-30
        salesPlanMap.put(new Date((dayTime + 24 * 3600 * 2) * 1000), 30.00);
        return salesPlanMap;
    }

    /**
     * 根据offset获取对应天的数据
     */
    public static double getSalesPlan(int offset) {
        Map<Date, Double> dateDoubleMap = initSalesPlanMap();
        Date date = initDateByDay();
        Double result = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, offset);
        date = calendar.getTime();
        System.out.println(date);
        result = dateDoubleMap.get(date);
        Set<Date> dates = dateDoubleMap.keySet();
        for (Date date1 : dates
        ) {
            if (date.toString().equals(date1.toString())) {
                result = dateDoubleMap.get(date1);
            }
        }
        return result;
    }

    /**
     * 获得当天零时零分零秒
     *
     * @return
     */
    public static Date initDateByDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static void main(String[] args) {
//        String str = "1,2,3,4,5";
//        System.out.println(str.substring(2, 3));
//        System.out.println(str.lastIndexOf(","));
        //输出明天的销量计划,预期结果=20
//        System.out.println(getSalesPlan(0));
//
//        System.out.println(getSalesPlan(1));
//        Set s = get(2, 5, 10);
//
////        System.out.println(testCase(2, 5, 10, s));
//        String s = "2+3/2-1*6=;1+2=;";
//        String[] strings = s.split(";");
//        String[] fuhao = {"+","-","*","/"};
//        String s1 = strings[0].substring(0,strings[0].indexOf("="));
//        if(s1.indexOf("-")== -1){
//            String[] jia = s1.split("\\+");
//            Double d = null;
//            for (String jian:jia
//            ) {
//                if(jian.indexOf("/")=-1 && jian.indexOf("*")==-1){
//                    if(jian.indexOf(".")!=-1){
//                        d = d+Double.parseDouble(jian);
//                    }else {
//                        d = d+Integer.parseInt(jian);
//                    }
//                }
//            }
//        }
//        final ExecutorService executorService = Executors.newCachedThreadPool();

        int[] nums = {7,6,5,4,3,2,1};
        kuaisu(0,nums.length-1,nums);
//        System.out.println(nums[6]);
        for (int num:nums
             ) {
            System.out.println(num);
        }
    }

    public static void kuaisu(int begin, int last, int[] nums) {
       int left = begin;
       int right = last;
       if(left>=right) return;
       int key = nums[left];
       while (left<right){
           while (left<right&&key<=nums[right]){
               right--;
           }
           if(left<right){
               nums[left] = nums[right];
               left++;
           }
           while (left<right&&key>nums[left]){
               left++;
           }
           if(left<right){
               nums[right] = nums[left];
               right--;
           }
       }
       nums[left] = key;
       kuaisu(begin,left-1,nums);
        kuaisu(left+1,last,nums);

    }


    static boolean testCase(int min, int max, int n, Set set) {
        if (set.size() != n) return false;
        boolean result = true;
        for (Object s : set
        ) {
            Double d = (Double) s;
            if (d < min || d > max) {
                result = false;
            }
        }
        return result;
    }
}
