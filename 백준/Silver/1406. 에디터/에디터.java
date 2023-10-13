import java.util.Stack;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> leftSt = new Stack<>();
        Stack<Character> rightSt = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            leftSt.push(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String command = br.readLine();
            char move = command.charAt(0);
            
            switch(move){
                case 'P':
                    leftSt.push(command.charAt(2));
                    break;
                case 'L':
                    if(!leftSt.isEmpty()){
                        rightSt.push(leftSt.pop());
                    }
                    break;
                case 'D':
                    if(!rightSt.isEmpty()){
                        leftSt.push(rightSt.pop());
                    }
                    break;
                case 'B':
                    if(!leftSt.isEmpty()){
                        leftSt.pop();
                    }
                    break;
            }
        }
        
        while(!leftSt.isEmpty()){
            rightSt.push(leftSt.pop());
        }
        
        while(!rightSt.isEmpty()){
            sb.append(rightSt.pop());
        }
        
        System.out.print(sb);
    }
}