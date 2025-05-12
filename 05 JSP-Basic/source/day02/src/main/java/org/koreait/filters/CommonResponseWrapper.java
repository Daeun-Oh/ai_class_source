package org.koreait.filters;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

public class CommonResponseWrapper extends HttpServletResponseWrapper {
    public CommonResponseWrapper(ServletResponse response) {
        super((HttpServletResponse) response);

        // 응답 처리 후 공통 수행 부분
        System.out.println("응답 처리 후 공통 처리 코드...");
    }
}
