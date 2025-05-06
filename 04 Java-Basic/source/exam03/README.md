# JDVC API
- Java DataBase Connectivity Application Programming Interface
- 거의 대부분 인터페이스로 구성되어 있다.
- 자바의 모든 데이터베이스 연결 기술의 표준안
- 모든 데이터베이스 연결 기술 제공. 업체는 이 표준에 따라서 통일된 방식으로 기술을 구현해야 한다.
- 설계 명세에 불과한 인터페이스이므로, 반드시 구현체가 따라온다.


---

## 의존성
`MySQL Connector/J`: JDBC API 구현체\
lombok\
`implementation 'org.apache.tomcat:tomcat-jdbc:11.0.6'`\
`compileOnly 'org.projectlombok:lombok:1.18.38'`\
`runtimeOnly 'com.mysql:mysql-connector-j:8.4.0'`

---

## DriverManager 클래스
- `static Connection getConnection(String url, String user, String password)`
- Connection 객체(연결 객체)를 생성하는 메서드
- 연결 요청마다 매번 새로운 연결 객체를 생성 / 동시 접속이 많은 경우 성능 저하
  - 해결 방법
    - 커넥션 풀: 연결 객체를 미리 생성해서 저장해 놓은 저장소
    - 유의점: 연결이 된 상태인데, 아무런 사용을 하지 않고 있다면, mysql 애플레케이션에서 연결을 임의로 해제 --> 연결 객체가 유효하지 않을 수 있다.
    - 유휴 객체를 사용했을 때 실제로는 연결이 끊겨 있을 가능성이 있다.
    - DB 연결이 정상적인지 주기적으로 체크 (SELECT 1 FROM DUAL) -> 응답을 하면 유효, 아니면 유휴 객체 제거, 다시 생성
    - 유휴 객체가 너무 오래 대기 상태가 되지 않도록, 일정 시간이 지나면 일괄 소멸시키고 다시 생성

---

# DataSource 인터페이스
- 커넥션 풀을 제공하는 라이브러리를 개발할 때 가이드라인 / 인터페이스
- javax.sql
- 구현체: Tomcat JDBC, HikariCP
- Connection getConnection()

---

## Connection 인터페이스
- `Statement createStatement();`
  - `int executeUpdate(String sql)`: 변경을 가하는 SQL - INSERT, UPDATE, DELETE, 반환값은 반영된 레코드의 개수
  - `ResultSet executeQuery(String sql)`: 조회를 위한 SQL - SELECT
    - `ResultSet`: 조회된 레코드의 주소 (커서)
      - `boolean next()`: 커서를 다음 칸으로 이동, 끝에 도달한 경우 false
      - `boolean previous()`: 커서를 이전 칸으로 이동, 처음에 도달한 경우 false
      - `get자료형(int colmnnIndex)`: 순서대로 컬럼 데이터를 가져올 때 (1, 2, 3, ...)
      - `get자료형(int columnName)`: 컬럼명으로 데이터를 가져올 때 -> 이걸 더 선호한다(순서는 바뀔 수 있기 때문에)
  - 외부에서 유입되는 데이터를 걸러주지 못하므로 해킹 위험이 있다.
- `PreparedStatement prepareStatement(String sql)`
  - `int executeUpdate()`
  - `ResultSet executeQuery()`
  - 데이터가 입력되는 부분을 `?`로 대체
  - `?`로 표기된 위차ㅣ에 데이터를 바인딩
  - `set자료형(순서번호, 값);` - 순서번호: 1부터 시작
- `CallableStatement prepareCall(String sql)`

---

## Transaction (트랜잭션)
- SQL 실행 단위
- COMMIT을 실행할 때까지 (데이터베이스에 영구적으로 반영될 때까지);
- `autoCommit(boolean ...)`: 자동 커밋 여부, 기본값 `false`
  - `commit()` 메서드를 호출해야 영구 반영
- `rollback()`: `commit()`하기 전에는 원상태로 복구 가능

---

# MyBatis 프레임워크
`implementation 'org.mybatis:mybatis:3.5.19'`
- https://mybatis.org/mybatis-3/ko/getting-started.html
- xml 설정, 자바코드 기준 설정
- SqlSessionFactory: SqlSession 객체 생성
- SqlSession 객체: SQL 실행

## Mapper 인터페이스
- `@Select`
- `@Insert`
- `@Update`
- `@Delete`
- `@Param`: `#{...}`에 대체가 될 이름을 지정할 때 사용
- 간단한 SQL 실행 시 사용하고, 복잡한 SQL은 한계가 있다.
- 복잡한 SQL은 Mapper.xml을 사용하고, Mapper 인터페이스와 함께 보완해서 사용한다.

## Mapper.xml


## 로거(Logger) 연동
`implementation 'org.slf4j:slf4j-api:2.0.17'`

LOG4J   API\
LOG4J2  API\
SLF4J   API  - Logback classic 구현체\

### 로그 레벨
FATAL: 심각한 오류\
ERROR: 문제가 있어 에러 메시지 출력\
WARN: 경고 메시지\
INFO: 일반적인 정보성 메시지\
DEBUG: 자세한 정보\
TRACE: 더 자세한 정보\

### 설정
- src/main/resources/logback.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration>
<configuration>

  <appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>%5level [%thread] - %msg%n</pattern>
    </encoder>
  </appender>

  <logger name="org.mybatis.example.BlogMapper">
    <level value="trace"/>
  </logger>
  <root level="error">
    <appender-ref ref="stdout"/>
  </root>

</configuration>
```

## 게시판

```
CREATE TABLE BOARD_DATA (
	seq BIGINT AUTO_INCREMENT PRIMARY KEY,
	poster VARCHAR(45) NOT NULL,
	subject VARCHAR(255) NOT NULL,
	content TEXT NOT NULL,
	regDt DATETIME DEFAULT CURRENT_TIMESTAMP,
	modDt DATETIME
);
```

- 비교 연산자 중 >, <는 태그로 인식할 수 있음
- 이때, 이것이 문자열로 인식할 수 있게 하는 코드는 다음과 같다.
```
<![CDATA[
    AND seq >= #{seq}
]]>
```