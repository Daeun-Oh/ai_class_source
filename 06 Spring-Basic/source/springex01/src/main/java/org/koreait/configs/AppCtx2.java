package org.koreait.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
//@Import(DBConfig.class)
//@ComponentScan("org.koreait.member") // 자동 스캔
@ComponentScan("org.koreait")
public class AppCtx2 {
    //@Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yy.MM.dd HH:mm");
    }


    /*
    @Bean
    @Qualifier("dtf2")
    public DateTimeFormatter dateTimeFormatter2() {
        return DateTimeFormatter.ofPattern("yyyy.MM.dd");
    }
    */
}
