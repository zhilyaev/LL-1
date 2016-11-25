package ll.tfya.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private final static int ERROR = -2;
    private final static int DROP  = -1;
    private final static int RIGHT  = 0;

    private final static int table[][] = {
            // 1    2   3
            // a    b   $
            {  1,   2,  ERROR},         //1 A
            {  3,   ERROR,  ERROR},     //2 B
            {  ERROR,   4,  5},         //3 Z
            {ERROR,   6,  ERROR},       //4 C
            {ERROR,   7,  ERROR},       //5 D
            {  8,   ERROR,  9},         //6 X
            {  DROP,   ERROR,  ERROR},  //7 a
            {  ERROR,   DROP,  ERROR},  //8 b
            {  ERROR,   ERROR,  RIGHT}, //9 $
    };

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new 	InputStreamReader(System.in));
        System.out.print("Input line: ");
        char[] lenta = (input.readLine() + "$").toCharArray();
        System.out.println("Lenta = "+String.valueOf(lenta));

        MyStack<String> stack = new MyStack<>();

        stack.push("$");
        stack.push("A");

        boolean flag = true;
        int i = 0;

        while(flag){
            System.out.println("Stack = "+stack);
            System.out.println("table["+stack.peek()+"]["+ lenta[i]+"]");

            switch (table   [RuleToRow(stack.peek())]
                            [RuleToCol((String.valueOf(lenta[i])))]
                    ){
                case 1:
                    System.out.println("Command №1");
                    stack.pop();
                    stack.push("B");
                    break;
                case 2:
                    System.out.println("Command №2");
                    stack.pop();
                    stack.push("D");
                    break;
                case 3:
                    System.out.println("Command №3");
                    stack.pop();
                    stack.push("Z");
                    stack.push("a");
                    break;
                case 4:
                    System.out.println("Command №4");
                    stack.pop();
                    stack.push("Z");
                    stack.push("C");
                    stack.push("C");
                    break;
                case 5:
                    System.out.println("Command №5");
                    stack.pop();
                    break;
                case 6:
                    System.out.println("Command №6");
                    stack.pop();
                    stack.push("a");
                    stack.push("b");
                    break;
                case 7:
                    System.out.println("Command №7");
                    stack.pop();
                    stack.push("X");
                    stack.push("b");
                    break;
                case 8:
                    System.out.println("Command №8");
                    stack.pop();
                    stack.push("D");
                    stack.push("a");
                    stack.push("a");
                    break;
                case 9:
                    System.out.println("Command №9");
                    stack.pop();
                    break;
                case ERROR:
                    System.out.println("Command ERROR");
                    flag = false;
                    break;
                case DROP:
                    System.out.println("Command DROP");
                    stack.pop();
                    i++;
                    break;
                case RIGHT:
                    System.out.println("Command RIGHT");
                    System.out.println("<S> String belongs to lang <$>");
                    flag = false;
                    break;
            }
        }



    }



    static int RuleToRow(String chr){
        return "ABZCDXab$".indexOf(chr);
    }

    static int RuleToCol(String chr){
        return "ab$".indexOf(chr);
    }

    private static class MyStack<Object> extends Stack<Object>{
        @Override
        public Object push(Object item) {
            System.out.println("PUSH -> "+item);
            return super.push(item);

        }

        @Override
        public synchronized Object pop() {
            System.out.println("DROP -> "+this.peek());
            return super.pop();
        }
    }

}
