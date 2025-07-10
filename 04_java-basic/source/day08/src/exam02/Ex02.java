package exam02;

import java.util.Stack;

public class Ex02 {
    public static void main(String[] args) {
        Stack<String> items = new Stack<>();
        items.push("가");
        items.push("나");
        items.push("다");

        while(items.size() > 0) {
            String item = items.pop();
            System.out.println(item);
        }
    }
}
