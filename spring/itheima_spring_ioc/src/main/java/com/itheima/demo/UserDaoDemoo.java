package com.itheima.demo;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserDaoDemoo {
    public static void main(String[] args) {
//        String a = "sss";
//        String b = "sss";
//        System.out.println(a==b);
//        char A = '9';
//        int numA = (int)A;
//        System.out.println(numA);
        LinkedList linkedList = new LinkedList();
        linkedList.add("sd");
        LinkedHashSet a = new LinkedHashSet();
//        Queue queue = new LinkedList<>();
//        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
//        concurrentLinkedQueue.offer("ss");//使用compareAndSet保证线程安全
//        AtomicInteger a = new AtomicInteger();
//        ReentrantLock takeLock = new ReentrantLock();
//        ArrayList list = new ArrayList();
//        list.add("ss");
//        Set set = new HashSet();
//        StringBuffer s= new StringBuffer();
//        s.append("S");
//        set.add("sss");
//        takeLock.lock();
//        LinkedBlockingQueue queue1 = new LinkedBlockingQueue();l
//        queue1.offer("ssssd");//ReentrantLock和AtomicInteger 保证线程安全
//        queue1.put("sdsds");
////        queue1.take();
////        ArrayBlockingQueue queue2 = new ArrayBlockingQueue(4);//ReentrantLock保证线程安全
////        queue2.put("sdsds");
//        HashSet seta = new HashSet();
//        seta.add("sdsd");
//        List lista = new ArrayList();
//        List list1 = new LinkedList();
//        list1.add("ssss");
//        lista.add("s");
        Map map = new HashMap();
        List list = new ArrayList();

//        HashMap map1 = new LinkedHashMap();
//
//        map.entrySet();
        Hashtable hashtable = new Hashtable();
//        hashtable.put("ss","ss");
//        hashtable.get("ss");
//        map.put("jixiao","sdsds");
        ConcurrentMap concurrentMap = new ConcurrentHashMap();//数组中链表的头节点作为锁
//        concurrentMap.put("ss","ss");
        Vector v = new Vector();
//        v.add("sss");
//        Animal c = new Cat();
//        c.chi();
//        String string = "aabbccdd";
//        string.charAt(1);
//        Scanner sc = new Scanner(System.in);
//        String input;
//        while(sc.hasNext()){
//            input = sc.nextLine();
//            String[] strs = input.split(" ");
//            int result = 0;
//            for(int i =strs.length-1;i>=0;i-- ){
//                if(strs[i].length() == 0){
//                    continue;
//                }
//                result = strs[i].length();
//            }
//            System.out.print(result);
//        }
//        System.out.println(piPei("abaa", "北京 杭州 北京 北京"));
//        int start = 0;
//        String S = "((())";
//        StringBuilder builder = new StringBuilder(S);
//        while(builder.toString().contains("()")){
//            int index = S.indexOf("()");
//            builder.delete(index,index+2);
//        }
//        System.out.println(builder.toString());
        int nums[] = {3,6,5,1,8};
        maxSumDivThree(nums);
    }
    public static int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length+1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i = 1;i<=nums.length;i++){
            if(nums[i-1]%3 == 0){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][0]+nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][1]+nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][2]+nums[i-1]);
            }else if(nums[i-1]%3 == 1){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]+nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+nums[i-1]);
            }else if(nums[i-1]%3 == 2){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]+nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0]+nums[i-1]);
            }
        }
        return dp[nums.length][0];
    }
    public static boolean piPei(String pattern,String string){
        String[] strs = string.split(" ");
        boolean result = true;
        Map map = new HashMap();
        if(pattern.length()!=strs.length){
            return false;
        }
        for(int i = 0;i<pattern.length();i++){
            if(map.get(pattern.charAt(i)) == null){
                map.put(pattern.charAt(i),strs[i]);
            }else {
                if(!map.get(pattern.charAt(i)).equals(strs[i])){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
    public static void mingming(){
        Scanner scan = new Scanner(System.in);
        Set<Integer> set = new HashSet();
        while(scan.hasNextLine()){
            Integer m = Integer.parseInt(scan.nextLine());
            set.add(m);
        }
        ArrayList list = new ArrayList();
        for(Integer m:set){
            list.add(m);
        }
        Integer[] nums = (Integer[])list.toArray();
        for(int i = 0;i<nums.length-1;i++){
            for(int j =0;j<nums.length-i-1;j++){
                if(nums[i]>nums[i+1]){
                    int temp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for(int i = 0;i<nums.length;i++){
            System.out.print(nums[i]);
        }
    }

}
