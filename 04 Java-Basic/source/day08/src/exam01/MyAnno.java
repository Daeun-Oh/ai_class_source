package exam01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*; // static으로 import하면, ElementType.METHOD -> METHOD

@Target({METHOD, TYPE, CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    int min() default 10;  // 최솟값 추가 정보(설정)
    int[] max() default 100;  // 최댓값 추가 정보(설정)
    String value(); // 기본 설정 항목
}
