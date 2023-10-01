import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Stack<Double> stack = new Stack<>();
        
        double[] arr = new double[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextDouble();
        }
        
        double result = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                stack.push(arr[s.charAt(i)-'A']);
            }else{
                if(!stack.isEmpty()){
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    
                    switch(s.charAt(i)){
                        case '+':
                            result = num2 + num1;
                            stack.push(result);
                            break;
                        case '-':
                            result = num2 - num1;
                            stack.push(result);
                            break;
                        case '*':
                            result = num2 * num1;
                            stack.push(result);
                            break;
                        case '/':
                            result = num2 / num1;
                            stack.push(result);
                            break;
                    }
                }
            }
        }
        
        System.out.printf("%.2f", stack.pop());
    }
}