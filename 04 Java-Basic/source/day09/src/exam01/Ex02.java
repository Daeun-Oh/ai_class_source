package exam01;

import java.util.*;

public class Ex02 {
    public static void main(String[] args) {
        //HashMap<String, String> members = new HashMap<>();
        //TreeMap<String, String> members = new TreeMap<>();  // 기본적으로 key 기준 오름차순
        TreeMap<String, String> members = new TreeMap<>(Comparator.reverseOrder());
        members.put("user01", "회원1");
        members.put("user02", "회원2");
        members.put("user03", "회원3");
        members.put("user04", "회원4");
        members.put("user05", "회원5");

        /*
        Set<Map.Entry<String, String>> entries = members.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.printf("key=%s, value=%s%n", entry.getKey(), entry.getValue()); // entry.getKey().toString(), entry.getValue().toString()
        }
        */

        for (Map.Entry<String, String> entry : members.entrySet()) {
            System.out.printf("key=%s, value=%s%n", entry.getKey(), entry.getValue()); // entry.getKey().toString(), entry.getValue().toString()
        }
    }
}
