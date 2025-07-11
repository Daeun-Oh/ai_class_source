package org.koreait.global.rests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor // 모든 요소를 매개변수로 초기화하는 생성자
@NoArgsConstructor  // 기본 생성자(매개변수 없는 생성자)
public class JSONError<T> {
    private HttpStatus status;
    private T message;
}
