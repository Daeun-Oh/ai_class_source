package org.koreait.member.controllers;

import jakarta.validation.Valid;
import org.koreait.global.exceptions.BadRequestException;
import org.koreait.global.rests.JSONError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController_EX2 {

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void join1(@RequestBody @Valid RequestJoin form, Errors errors) {
        if (errors.hasErrors()) {
            throw new BadRequestException(errors);
        }

        System.out.println(form);
    }

    @PostMapping("/join2")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> join2(@RequestBody @Valid RequestJoin form, Errors errors) {
        if (errors.hasErrors()) {
            throw new BadRequestException(errors);
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/join3")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void join3(@RequestBody @Valid RequestJoin form, Errors errors) {
        if (errors.hasErrors()) {
            throw new BadRequestException(errors);
        }

        System.out.println(form);
    }

//    @PostMapping("/join")
//    public ResponseEntity<Object> join(@RequestBody @Valid RequestJoin form, Errors errors) {
//
//        if (errors.hasErrors()) {
//            List<String> errorMessages = errors.getFieldErrors().stream().map(e -> e.getDefaultMessage()).toList();
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
//            return ResponseEntity.badRequest().body(errorMessages);
//        }
//
////        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        return ResponseEntity.noContent().build();
//    }

    @PostMapping("/login")
    public void login() {
        boolean result = false;
        if (!result) {
            throw new IllegalArgumentException("잘못된 요청...");
        }
    }

    /**
     * Error가 발생했을 시 유입됨
     * - @ExceptionHandler: Spring MVC에서 전역 예외를 처리
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONError<Object>> errorHandler(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Object message = e.getMessage();
        if (e instanceof BadRequestException badRequestException) {
            message = badRequestException.getMessages();
        }
        JSONError<Object> error = new JSONError<>(status, message);

        return ResponseEntity.status(status).body(error);
    }

//    @PostMapping("/join")
//    public ResponseEntity<Object> join(@RequestBody @Valid RequestJoin form, Errors errors) { // * RequestBody 매우중요 *
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("header1", "value1");
//        headers.add("header2", "value2");
//
//        ResponseEntity<Object> response = new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
//
//        if (errors.hasErrors()) {
//            List<String> errorMessages =  errors.getFieldErrors().stream().map(e -> e.getDefaultMessage()).toList();
//            response = new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
//        }
//        System.out.println(form);
//
//        return response;
//    }
}
