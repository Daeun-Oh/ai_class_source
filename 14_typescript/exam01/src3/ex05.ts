type UserType = {
  email: string
  username: string
  age: number
}

type AddressType = {
  zipcode: string
  address: string
}

// Intersection Type (교차 타입): 두 타입의 모든 속성을 가진 새로운 타입을 만든다.
type UserWithAddressType = UserType & AddressType

const user02: UserWithAddressType = {
  email: "user02@test.org",
  username: "사용자02",
  age: 30,
  zipcode: "010101",
  address: "인천광역시 동구 빵꾸",
}

// Union Type (선택 타입): 여러 타입 중 하나를 가질 수 있다.
function getUser(): UserType | void {}

// ! : Non-Null 어선셜
function printUser(user?: UserType) {
    console.log(user!.username)
}

// ? : Optional Property - 있을 수도, 없을 수도 있다 -> user의 username도 그렇다 -> 없으면 기본값
function printUser2(user?: UserType) {
  console.log(user?.username ?? '기본값')
}

printUser()
