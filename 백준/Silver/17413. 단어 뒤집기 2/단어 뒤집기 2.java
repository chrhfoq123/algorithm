import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean tag = false;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '<'){
                tag = true;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(s.charAt(i));
            }else if(s.charAt(i) == '>'){
                tag = false;
                sb.append(s.charAt(i));
            }else if(tag){
                sb.append(s.charAt(i));
            }else{
                if(s.charAt(i) == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(s.charAt(i));
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        System.out.print(sb);
    }
}