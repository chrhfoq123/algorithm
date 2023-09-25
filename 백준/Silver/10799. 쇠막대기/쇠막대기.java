import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String s = sc.next();
        
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i-1) == '('){
                    stack.pop();
                    answer += stack.size();
                }else{
                    stack.pop();
                    answer += 1;
                }
            }
        }
        System.out.print(answer);
    }
}