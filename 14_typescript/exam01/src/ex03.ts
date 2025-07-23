type UserType = {
    email: string
    password?: string
    name: string
}

type AddressType = {
    zondcode: string
    address: string
}

// const user01: UserType & AddressType = {  // &: 교집합 - 결합된 타입이 모두 필수
//     email: 'user01@test.org',
//     name: '사용자01',
//     zondcode: '1234',
//     address: '주소'
// }

type UserWithAddressType = UserType & AddressType

const user01: UserWithAddressType = {
  // &: 교집합 - 결합된 타입이 모두 필수
  email: "user01@test.org",
  name: "사용자01",
  zondcode: "1234",
  address: "주소",
}