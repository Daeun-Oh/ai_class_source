package org.koreait.global.configs;

import lombok.RequiredArgsConstructor;
import org.koreait.global.member.validators.JoinValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("org.koreait")
@Import(ControllerConfig.class)
public class MvcConfig implements WebMvcConfigurer {

//    @Autowired
//    private JoinValidator joinValidator;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**") // "/*": 현재 폴더 포함 모든 하위 폴더, "/**": 현재 폴더 포함 모든 하위 폴더의 모든 파일
                .addResourceLocations("classpath:/static/");    // 정적 자원 경로
    }

    // 컨트롤러 생성 없이 주소와 템플릿을 연동하는 설정
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/company")
                .setViewName("company/main");

        registry.addViewController("/")
                .setViewName("main/index");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }

//    @Override
//    public Validator getValidator() {
//        return joinValidator;
//    }
}
