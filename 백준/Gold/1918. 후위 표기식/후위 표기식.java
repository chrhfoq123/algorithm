import java.util.Scanner;
import java.util.Stack;

public class Main {
    
    public static int priority(char c){
        if(c == '*' || c == '/')
            return 2;
        else if(c == '+' || c == '-')
            return 1;
        else{
            return 0;
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                sb.append(s.charAt(i));
            }else if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(s.charAt(i))){
                    sb.append(stack.pop());
                }
                stack.push(s.charAt(i));
            }
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        System.out.print(sb);
    }
}