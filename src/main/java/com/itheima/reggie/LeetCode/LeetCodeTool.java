package com.itheima.reggie.LeetCode;

import java.util.*;

public class LeetCodeTool {

    public static void main(String[] args) {
        List<List<String>> list = listString("[[\"AXA\",\"EZE\"],[\"EZE\",\"AUA\"],[\"ADL\",\"JFK\"],[\"ADL\",\"TIA\"],[\"AUA\",\"AXA\"],[\"EZE\",\"TIA\"],[\"EZE\",\"TIA\"],[\"AXA\",\"EZE\"],[\"EZE\",\"ADL\"],[\"ANU\",\"EZE\"],[\"TIA\",\"EZE\"],[\"JFK\",\"ADL\"],[\"AUA\",\"JFK\"],[\"JFK\",\"EZE\"],[\"EZE\",\"ANU\"],[\"ADL\",\"AUA\"],[\"ANU\",\"AXA\"],[\"AXA\",\"ADL\"],[\"AUA\",\"JFK\"],[\"EZE\",\"ADL\"],[\"ANU\",\"TIA\"],[\"AUA\",\"JFK\"],[\"TIA\",\"JFK\"],[\"EZE\",\"AUA\"],[\"AXA\",\"EZE\"],[\"AUA\",\"ANU\"],[\"ADL\",\"AXA\"],[\"EZE\",\"ADL\"],[\"AUA\",\"ANU\"],[\"AXA\",\"EZE\"],[\"TIA\",\"AUA\"],[\"AXA\",\"EZE\"],[\"AUA\",\"SYD\"],[\"ADL\",\"JFK\"],[\"EZE\",\"AUA\"],[\"ADL\",\"ANU\"],[\"AUA\",\"TIA\"],[\"ADL\",\"EZE\"],[\"TIA\",\"JFK\"],[\"AXA\",\"ANU\"],[\"JFK\",\"AXA\"],[\"JFK\",\"ADL\"],[\"ADL\",\"EZE\"],[\"AXA\",\"TIA\"],[\"JFK\",\"AUA\"],[\"ADL\",\"EZE\"],[\"JFK\",\"ADL\"],[\"ADL\",\"AXA\"],[\"TIA\",\"AUA\"],[\"AXA\",\"JFK\"],[\"ADL\",\"AUA\"],[\"TIA\",\"JFK\"],[\"JFK\",\"ADL\"],[\"JFK\",\"ADL\"],[\"ANU\",\"AXA\"],[\"TIA\",\"AXA\"],[\"EZE\",\"JFK\"],[\"EZE\",\"AXA\"],[\"ADL\",\"TIA\"],[\"JFK\",\"AUA\"],[\"TIA\",\"EZE\"],[\"EZE\",\"ADL\"],[\"JFK\",\"ANU\"],[\"TIA\",\"AUA\"],[\"EZE\",\"ADL\"],[\"ADL\",\"JFK\"],[\"ANU\",\"AXA\"],[\"AUA\",\"AXA\"],[\"ANU\",\"EZE\"],[\"ADL\",\"AXA\"],[\"ANU\",\"AXA\"],[\"TIA\",\"ADL\"],[\"JFK\",\"ADL\"],[\"JFK\",\"TIA\"],[\"AUA\",\"ADL\"],[\"AUA\",\"TIA\"],[\"TIA\",\"JFK\"],[\"EZE\",\"JFK\"],[\"AUA\",\"ADL\"],[\"ADL\",\"AUA\"],[\"EZE\",\"ANU\"],[\"ADL\",\"ANU\"],[\"AUA\",\"AXA\"],[\"AXA\",\"TIA\"],[\"AXA\",\"TIA\"],[\"ADL\",\"AXA\"],[\"EZE\",\"AXA\"],[\"AXA\",\"JFK\"],[\"JFK\",\"AUA\"],[\"ANU\",\"ADL\"],[\"AXA\",\"TIA\"],[\"ANU\",\"AUA\"],[\"JFK\",\"EZE\"],[\"AXA\",\"ADL\"],[\"TIA\",\"EZE\"],[\"JFK\",\"AXA\"],[\"AXA\",\"ADL\"],[\"EZE\",\"AUA\"],[\"AXA\",\"ANU\"],[\"ADL\",\"EZE\"],[\"AUA\",\"EZE\"]]");
        System.out.println(list);
    }

    public static int[] singleArr(String s){
        List<Integer> list = new ArrayList<>();
        s = s.substring(1,s.length()-1);
        String[] split = s.split(",");
        for (String s1:split) {
            list.add(Integer.parseInt(s1));
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }

    public static List<List<String>> listString(String s){
        s = s.substring(1,s.length()-1);
        int len;
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        while (true){
            boolean judge = false;
            len=s.indexOf(']');
            String s1 = s.substring(s.indexOf('[')+1,len);
            if(len+2<s.length()){
                s = s.substring(len+2);
            }else {
                judge=true;
            }
            String[] split = s1.split(",");
            for (int i = 0; i < split.length; i++) {
                split[i]=split[i].substring(1,split[i].length()-1);
            }
            list1.addAll(Arrays.asList(split));
            list.add(list1);
            list1=new ArrayList<>();
            if(judge){
                break;
            }
        }
        return list;
    }

    //创建二维数组对象的方法
    public static int[][] doubleArr(String s){
        s = s.substring(1,s.length()-1);
        int len;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        while (true){
            boolean judge = false;
            len=s.indexOf(']');
            String s1 = s.substring(s.indexOf('[')+1,len);
            if(len+2<s.length()){
                s = s.substring(len+2);
            }else {
                judge=true;
            }
            String[] split = s1.split(",");
            for (String value : split) {
                list1.add(Integer.parseInt(value));
            }
            list.add(list1);
            list1=new ArrayList<>();
            if(judge){
                break;
            }
        }
        int[][] ints = new int[list.size()][list.get(0).size()];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j]=list.get(i).get(j);
            }
        }
        return ints;
    }

    //创建二维char数组对象的方法
    public static char[][] doubleCharArr(String s){
        s = s.substring(1,s.length()-1);
        int len;
        List<List<Character>> list = new ArrayList<>();
        List<Character> list1 = new ArrayList<>();
        while (true){
            boolean judge = false;
            len=s.indexOf(']');
            String s1 = s.substring(s.indexOf('[')+1,len);
            if(len+2<s.length()){
                s = s.substring(len+2);
            }else {
                judge=true;
            }
            String[] split = s1.split(",");
            for (String value : split) {
                list1.add(value.charAt(1));
            }
            list.add(list1);
            list1=new ArrayList<>();
            if(judge){
                break;
            }
        }
        char[][] ints = new char[list.size()][list.get(0).size()];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j]=list.get(i).get(j);
            }
        }
        return ints;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
