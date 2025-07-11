package org.koreait.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.pokemon.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootTest
public class Ex02 {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper om;

    @Test
    void test1() {
        String url = "https://pokeapi.co/api/v2/pokemon";  // 포켓몬 API의 포켓몬 목록을 반환
//        String response = restTemplate.getForObject(URI.create(url), String.class);
        // restTemplate을 사용하여 HTTP GET 요청을 보냄
        // URI.create(url): 문자열 URL -> URI 객체로 변환
        // String.class: 응답을 문자열(JSON)로 받겠다
        // -> response에는 API로부터 받아온 JSON 문자열이 담김

        ApiResponse response = restTemplate.getForObject(URI.create(url), ApiResponse.class);

        System.out.println(response);
    }

    @Test
    void test2() {
        String url = "https://pokeapi.co/api/v2/pokemon";  // 포켓몬 API의 포켓몬 목록을 반환
        ResponseEntity<String> response = restTemplate.getForEntity(URI.create(url), String.class);
        System.out.println("----- 응답 헤더 -----");
        HttpHeaders headers = response.getHeaders();
        headers.forEach((k, v) -> System.out.printf("%s:%s%n", k, v));

        System.out.println("----- 응답 바디 -----");
        String body = response.getBody();
        System.out.println(body);
    }

    @Test
    void test3() throws Exception {
        RequestJoin form = new RequestJoin();
        form.setName("고영희");
        form.setEmail("koyounghee@test.org");
        form.setPassword("1234");

        String body = om.writeValueAsString(form);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        String url = "http://localhost:8080/api/v1/member/join";
        ResponseEntity<Void> response = restTemplate.exchange(URI.create(url), HttpMethod.POST, request, Void.class);
        System.out.println(response);
    }

    @Test
    void test4() {
        String url = "http://localhost:8080/api/v1/member/join2";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "고영희");
        params.add("email", "koyounghee@test.org");
        params.add("password", "1234");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Void> response = restTemplate.exchange(URI.create(url), HttpMethod.POST, request, Void.class);

        System.out.println(response);
    }
}
