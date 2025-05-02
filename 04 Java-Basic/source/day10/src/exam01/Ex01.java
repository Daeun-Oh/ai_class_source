package exam01;

import java.util.Comparator;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<String> items = List.of("Apple", "Orange", "Orange", "Melon", "Mango");
        /**
         * 중간 연산: 스트림을 변형하거나 필터링
         *           1) 최종 연산이 호출되기 전까지 대기(연기),
         *              최종 연산이 호출되면 스트림을 소비하면서 연산 진행 -> 지연된(lazy) 연산
         *           2) 반환값이 Stream (메서드 체이닝 가능)
         *           ex) filter(), map(), sorted(), distinct() 등
         * 최종 연산: 스트림을 소비(실행)하고 결과 생성
         *           1) 스트림 파이프라인이 이 시점에 실제로 작동함
         *           2) 스트림은 최종 연산 후 재사용 불가 (일회용)
         *           3) 반환값이 Stream이 아님
         *           ex) forEach(), collect(), count(), reduce() 등
         */
        items.stream()
                .sorted(Comparator.reverseOrder())  // 중간 연산, 요소를 내림차순 정렬
                .distinct()                         // 중간 연산, 중복 요소 제거
                .forEach(System.out::println);      // 최종 연산, 각 요소를 출력
    }
}
