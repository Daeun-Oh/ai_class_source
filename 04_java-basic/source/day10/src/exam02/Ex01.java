package exam02;

import java.util.Optional;

public class Ex01 {
    public static void main(String[] args) {
        String valueN = null;
        Optional<String> opt  = Optional.ofNullable(valueN);

        if (opt.isPresent()) {
            String valueG = opt.get();  // 값이 null이면 NoSuchElementException이 발생
            System.out.println(valueG);
        }

        String valueOE = opt.orElse("기본값");
        System.out.println(valueOE);

        String valueOEG = opt.orElseGet(() -> {
            return "기본값";
        });
        System.out.println(valueOEG);
    }
}
