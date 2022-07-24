import com.itheima.reggie.LeetCode.LeetCodeTool;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"cpctxzh","bryvgjqmj","wedqhqrmyc","ee","lafzximxh","lojzxfel","flhs"},new String[]{"wbhdgqphq","wbhdgqphq","mxxajogm","wbhdgqphq","wbhdgqphq","mxxajogm","mxxajogm"},new int[]{15,5,7,16,16,10,13});
//        System.out.println(foodRatings.highestRated("korean"));
//        System.out.println(foodRatings.highestRated("japanese"));
//        foodRatings.changeRating("sushi",16);
//        System.out.println(foodRatings.highestRated("japanese"));
//        foodRatings.changeRating("ramen",16);
//        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("lojzxfel",1);
        System.out.println(foodRatings.highestRated("mxxajogm"));
        System.out.println(foodRatings.highestRated("wbhdgqphq"));
        System.out.println(foodRatings.highestRated("mxxajogm"));
    }
}

class FoodRatings {

    Map<String,Map<Integer,String>> map = new HashMap<>();
    Map<String,myFood> stringMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Map<Integer,String> maps;
            if(map.containsKey(cuisines[i])){
                maps = map.get(cuisines[i]);
            }else {
                maps = new TreeMap<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                });
            }
            if(!maps.containsKey(ratings[i])){
                maps.put(ratings[i],foods[i]);
            }
            map.put(cuisines[i],maps);
            stringMap.put(foods[i],new myFood(cuisines[i],ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        myFood myFood = stringMap.get(food);
        Integer ratings = myFood.ratings;
        String cuisines = myFood.cuisines;
        Map<Integer, String> map = this.map.get(cuisines);
        String s = map.get(ratings);
        map.remove(ratings,s);
        map.put(newRating,s);
        this.map.put(cuisines,map);
        stringMap.put(food,new myFood(cuisines,newRating));
    }

    public String highestRated(String cuisine) {
        Map<Integer, String> map = this.map.get(cuisine);
        List<String> list = new ArrayList<>();
        int judge = Integer.MIN_VALUE;
        for (Integer i:map.keySet()) {
            if(i>=judge){
                judge=i;
                list.add(map.get(i));
            }else {
                break;
            }
        }
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(index).compareTo(list.get(i))>0){
                index = i;
            }
        }
        return list.get(index);
    }
}

class myFood{
    String cuisines;
    Integer ratings;

    public myFood(String cuisines, Integer ratings) {
        this.cuisines = cuisines;
        this.ratings = ratings;
    }
}