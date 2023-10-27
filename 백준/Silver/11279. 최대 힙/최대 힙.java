import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    
    private static ArrayList<Integer> heap;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        heap = new ArrayList<>();
        heap.add(0);
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x != 0){
                insert(x);
            }else{
                sb.append(delete()).append("\n");
            }
        }
        
        System.out.print(sb);
    }
    
    public static void insert(int value){
        heap.add(value);
        int size = heap.size()-1;
        
        while(size > 1 && heap.get(size/2) < heap.get(size)){
            int tmp = heap.get(size/2);
            heap.set(size/2, heap.get(size));
            heap.set(size, tmp);
            
            size /= 2;
        }
    }
    
    public static int delete(){
        if(heap.size()-1 < 1){
            return 0;
        }
        
        int deleteItem = heap.get(1);
        
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        
        int pos = 1;
        
        while((pos * 2) < heap.size()){
            int max = heap.get(pos*2);
            int maxPos = pos * 2;
            
            if((pos*2+1) < heap.size() && max < heap.get(pos*2+1)){
                max = heap.get(pos*2+1);
                maxPos = pos*2+1;
            }
            
            if(max < heap.get(pos)){
                break;
            }
            
            int tmp = heap.get(pos);
            heap.set(pos, max);
            heap.set(maxPos, tmp);
            pos = maxPos;
        }
        
        return deleteItem;
    }
}