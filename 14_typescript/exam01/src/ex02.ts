// 원시 타입 자료형: number, string, boolean, null, undefined, ...
let emplyeeName: string = '오다은'

// 배열
const fruits: string[] = []  // string 자료형만 배열에 추가 가능
fruits.push('사과')
//fruits.push(10) -> number 불가

const fruits2: (string|number)[] = []  // union 연산자(|)를 사용해 string, number 자료형으로 한정 (소괄호 필수)
fruits2.push('사과')
fruits2.push(10)
//fruits2.push(false) -> boolean 불가

// 배열 - 자료형의 개수과 순서를 고정 (튜플)
// const fruits3: [string, number] = ['사과', 10]
const fruits3: [string, number][] = []
fruits3.push(['apple', 10])

// 객체 타입
// const user: {name: string, age: number} = {
//     name: '안예은',
//     age: 34,
// }

type userType = {
  name: string
  age: number
  address?: string // ?: Optional Property(선택적 속성) - 있어도 되고, 없어도 되고
}

const user: userType = {
    name: '안예은',
    age: 34,
}
