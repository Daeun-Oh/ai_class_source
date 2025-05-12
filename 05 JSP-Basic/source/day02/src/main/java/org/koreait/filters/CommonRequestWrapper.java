package org.koreait.filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

/**
 * HttpServletRequestWrapper에는 기본 생성자가 없다.
 * 때문에 매개변수가 있는 생성자를 재정의해야 빨간 줄이 사라진다!
 */
public class CommonRequestWrapper extends HttpServletRequestWrapper {
    public CommonRequestWrapper(ServletRequest request) {
        super((HttpServletRequest) request);

        // 요청 처리 전 공통 수행 부분
        System.out.println("요청 처리 전 공통 처리 코드...");
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);

        if (value != null && !value.isBlank()) {
            return String.format("★%s★", value);
        }

        return value;
    }
}
