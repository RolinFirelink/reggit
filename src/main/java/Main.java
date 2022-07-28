import com.itheima.reggie.LeetCode.LeetCodeTool;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.validSquare(new int[]{1,0},new int[]{-1,0},new int[]{0,1},new int[]{0,-1});
    }
}

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        int hengL = 0,zongL = 0;
        double[] index = new double[2];
        //判断角度
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            boolean heng = true,zong = true;
            for (int j = 0; j < list.size(); j++) {
                if(i==j){
                    continue;
                }
                int[] arr2 = list.get(j);
                if(arr[0]==arr2[0]){
                    zongL=Math.abs(arr2[1]-arr[1]);
                    heng=false;
                    index[0]=arr[0];
                }else if(arr[1]==arr2[1]){
                    hengL=Math.abs(arr2[0]-arr[0]);
                    zong=false;
                    index[1]=arr[1];
                }
            }
        }
        //判断长度
        if(zongL != hengL){
            return false;
        }
        double len = -1;
        for (int[] intsarr:list) {
            double[] doubles = new double[2];
            for (int i = 0; i < intsarr.length; i++) {
                doubles[i]=intsarr[i];
            }
            double v = Math.pow(Math.abs(index[0] - doubles[0]), 2) + Math.pow(Math.abs(index[1] - doubles[1]), 2);
            if(len==-1){
                len= v;
            }
            if(len!=-1){
                if(len!= v){
                    return false;
                }
            }
        }
        return true;
    }
}