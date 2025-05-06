# 객체 지향 설계 5대 원칙 (SOLID)
## 1. SRP (Single Responsibility Principle)
\: 단일 책임 원칙
- 하나의 클래스는 하나의 책임만 가져야 한다.
- 예) 하나의 클래스가 역할을 3개 가진 경우, 1개 역할을 변경했을 때 나머지 2개에 영향을 줄 수도 있다 (부작용이 생긴다) -> X

## 2. OCP (Open-Closed Principle) *
\: 개방-폐쇄 원칙
- 확장에는 열려 있고, 변화에는 닫혀 있는 구조
- 전략 패턴

## 3. LSP (Liskov Substitution Principle)
\: 리스코프 치환 원칙
- 리스코프 치환 원칙을 1988년 바바라 리스코프(Barbara Liskov)가 올바른 상속 관계의 특징을 정의하기 위해 발표한 것
- 상위 타입의 객체를 하위 타입의 객체로 대체하여도 정상 동작해야 하고, 그 반대 관계도 정상 동작해야 한다.
- 다형성

## 4. ISP (Interface Segregation Principle)
\: 인터페이스 분리 원칙
- 하나의 인터페이스에 의존하지 말고 여러 인터페이스로 역할 별로 분리해서 정의(설계)
- 예) java.time 패키지, Temporal, TemporalAccesor, TemporalAdjustor
- 예) List, Iterable, Comparable, Serializable, ...

## 5. DIP (Dependency InversionPrinciple)
\: 의존 역전 원칙
- 구체화에 의존하지 말고, 추상화에 의존해라
```java
List<String> items = new LinkedList<>();

void func(List<String> items) {
    
}
```
