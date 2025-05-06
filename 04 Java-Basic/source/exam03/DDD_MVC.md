### DDD - Domain Driven Design : 도메인 주도 설계
- Domain: 영역, 전문가 영역

### MVC
- 역할 분담 모델\
- 사용자 UI가 포함된 애플리케이션에 최적화된 모델\

M - Model
  - 데이터, 기능(Service)
  - 예) 회원가입 기능(JoinService)
    - DTO(Data Transfer Object): 데이터 전달용 객체
    - Validator: 사용자의 요청 데이터를 검증
    - DAO(Data Access Object): 데이터 접근 객체
    - ...
    - VO(Value Object): 변경을 가할 필요가 없는 값을 담고 있는 객체 (DB에서 조회한 결과 등)

V - View
  - 출력

C - Controller
  - 사용자의 요청이 들어오면 요청을 처리할 수 있는 모델(서비스)을 찾고, 처리 결과를 View에 요청하여 출력
  - 중재자: 사용자의 요청과 처리에 대한 중재
  - 모든 사용자의 요청이 유입되는 창구