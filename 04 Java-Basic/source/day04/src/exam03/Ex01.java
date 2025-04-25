package exam03;

import java.io.IOException;
import java.io.InputStream;

public class Ex01 {
    public static void main(String[] args) {
        //Calculator cal = new Calculator();
        Calculator cal = new SimpleCalculator();
        int result = cal.add(10, 20);
        System.out.println(result);

        System.out.println(cal.num);
        cal.commonMethod();
    }
}
