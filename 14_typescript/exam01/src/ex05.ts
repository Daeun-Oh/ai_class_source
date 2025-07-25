// 매개변수 - string, 반환값 - 없음
function sayHello(name: string): void {
    // return name -> 반환 불가
}

function sayHello2(name: string): string {
    return `${name}님 반갑습니다!`
}

// 콜백 함수 타입: 매개변수 - string, 반환값 - 없음
type callbackType = (a: string) => void

function sayHello3(name: string, callback: callbackType) {
  console.log("name", name)
  callback(name)
}