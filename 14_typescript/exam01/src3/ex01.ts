// 일반적인 형태의 클래스: 속성 선언 및 생성자에서 초기화
class Point {
  x: number
  y: number

  constructor(x: number, y: number) {
    this.x = x
    this.y = y
  }
}

// 생성자 매개변수 속성을 자동 생성 및 초기화
class Point2 {
  constructor(public x: number, public y: number) {}
}

// 기본값 설정: 매개변수를 1개만 넣으면 x로 들어가고 y는 자동으로 10이 된다.
// - TypeScript는 Python처럼 오버로딩을 지원하지 않는다.
// - 기본값은 뒤에서부터 지정해야 한다.
class Point3 {
  constructor(public x: number, public y: number = 10) {}
}

// Optional Property (선택적 속성): y는 없어도 되고, undefined가 될 수 있다.
class Point4 {
  constructor(public x: number, public y?: number) {}
}

const p1 = new Point(10, 20)
console.log(`x: ${p1.x}, y: ${p1.y}`)
