package classesEx;

import java.util.StringTokenizer;

public class Ex_Tokenizer2 {
    public static void main(String[] args) {
        String expression = "x=100+(200+100)/2";
        StringTokenizer st = new StringTokenizer(expression, "+-*/=()", true);

        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
