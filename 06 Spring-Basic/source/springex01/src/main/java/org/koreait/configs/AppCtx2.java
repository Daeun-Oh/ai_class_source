package org.koreait.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.time.format.DateTimeFormatter;

@Configuration
//@Import(DBConfig.class)
//@ComponentScan("org.koreait.member") // 자동 스캔
//@ComponentScan("org.koreait")
//@ComponentScan(basePackages = "org.koreait",
//                excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ManualBean.class))
//@ComponentScan(basePackages = "org.koreait",
//                excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, // 자동 스캔에서 배제
//                                                        classes = MemberDao.class))
//@ComponentScan(basePackages = "org.koreait",
//                excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,   // 자동 스캔에서 배제
//                                                        pattern = "org.koreait.member.dao.*Dao"))   // 해당 경로에 있는 모든 Dao 파일을 배제한다 (ANT 패턴)
//@ComponentScan(basePackages = "org.koreait",
//        excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,   // 자동 스캔에서 배제
//                                                pattern = "org.koreait..*Dao"))   // koreait 포함한 하위의 모든 Dao 파일을 배제한다 (ANT 패턴)
@ComponentScan(basePackages = "org.koreait",
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,   // 자동 스캔에서 배제
                                                pattern = "org.koreait.member\\..*Dao"))
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
