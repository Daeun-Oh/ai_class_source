package org.koreait.configs;

import org.koreait.person.Greeter;
import org.springframework.context.annotation.Bean;

/**
 * @Configuration
 * - Spring 설정 클래스(Configuration class)임을 나타냄
 * - Spring Bean들을 정의하는 곳임을 Spring에게 알려주는 역할
 * @Bean
 * - Spring 컨테이너가 관리할 객체임을 명시
 */
//@Configuration
public class AppCtx {
    @Bean
    public Greeter greeter() {
        return new Greeter();
    }
}
