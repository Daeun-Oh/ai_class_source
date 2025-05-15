package org.koreait.configs;

import org.koreait.proxy.Calculator;
import org.koreait.proxy.RecCalculator;
import org.koreait.proxy3.CacheCalculator;
import org.koreait.proxy3.PerformanceCalculator3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)    // 서브클래스 기반의 프록시로 변환
@EnableAspectJAutoProxy
public class AppCtx2 {

    @Bean
    public CacheCalculator cacheCalculator() {
        return new CacheCalculator();
    }

    @Bean
    public PerformanceCalculator3 performanceCalculator3() {
        return new PerformanceCalculator3();
    }

    @Bean
    public Calculator recCalculator() {
        return new RecCalculator();
    }
}
