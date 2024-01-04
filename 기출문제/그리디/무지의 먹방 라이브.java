import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    class Food{
        int time; //음식당 먹는데에 걸리는 시간
        int idx; //음식 순서
        
        Food(int time, int idx){
            this.time = time;
            this.idx = idx;
        }
    };
    
    public int solution(int[] food_times, long k) {
        LinkedList<Food> foods = new LinkedList<>();
        int n = food_times.length; //음식의 수
        
        for(int i=0; i<n; i++){
            foods.add(new Food(food_times[i], i+1));
        }
        
        Collections.sort(foods, new Comparator<Food>(){
            @Override
            public int compare(Food f1, Food f2){
                return f1.time - f2.time;
            }
        });
        
        int preTime = 0; //이전 시간
        int i = 0; //몇번째 처리인지에 대한 인덱스
        for(Food f : foods){
            long diff = f.time - preTime;
            if(diff != 0){
                long spend = diff * n; //쓸 수 있는 시간
                if(spend <= k){
                    k -= spend;
                    preTime = f.time;
                }else{
                    k %= n;
                    Collections.sort(foods.subList(i, food_times.length), new Comparator<Food>(){
                        @Override
                        public int compare(Food f1, Food f2){
                            return f1.idx - f2.idx;
                        }
                    });
                    
                    return foods.get(i+(int)k).idx;
                }
            }
            i++;
            n--;
        }
        
        return -1;
    }
}
