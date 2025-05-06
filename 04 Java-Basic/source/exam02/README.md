# lombok

\> 자바 클래스에서 반복적으로 작성되는 **Getter, Setter, 생성자, toString 등 메서드를 자동 생성**해주는 라이브러리

---

## 📌 주요 어노테이션 정리

### ✅ 기본 메서드 자동 생성
- `@Getter`, `@Setter`  
  → Getter / Setter 메서드 자동 생성

- `@ToString`  
  → `toString()` 메서드 자동 재정의  
  \- `@ToString.Exclude` : 특정 필드를 `toString()`에서 제외

- `@EqualsAndHashCode`  
  → `equals(...)` 및 `hashCode()` 자동 재정의

- `@Data`  
  → `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode` 등을 모두 포함

---

### ✅ 생성자 관련
- `@AllArgsConstructor`  
  → 모든 인스턴스 변수를 매개변수로 받는 생성자 생성

- `@NoArgsConstructor`  
  → 매개변수 없는 기본 생성자 생성  
  \- 예: `@NoArgsConstructor(access = AccessLevel.PUBLIC)`  
  → 접근 제어자 지정 가능

- `@RequiredArgsConstructor`  
  → **필수 필드만 매개변수로 받는 생성자** 생성  
  \- 필수: `@NonNull`, 또는 `final` 필드  
  → 초기화 안 하면 컴파일 오류 발생

---

### ✅ 빌더 패턴
- `@Builder`  
  → 객체 생성 시 **Builder 디자인 패턴** 적용

```text
1. 외부에서 new로 생성자 직접 호출하지 않음 (생성자는 주로 private)
2. 내부에 빌더 클래스 생성 → 값을 설정한 뒤 객체 생성
3. 가독성 향상 + 선택적 파라미터 설정 가능
