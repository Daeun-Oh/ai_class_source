package exam02;

public class Ex06 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(500);
        sb.append("ABC").append("DEF").append("GHI");   // 메서드 체이닝
        /*
        StringBuffer sb1 = sb.append("ABC");    // return this
        StringBuffer sb2 = sb.append("DEF");
        */
    }
}
