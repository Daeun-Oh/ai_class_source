type UserType2 = {
  readonly email: string
  name: string
}

const user01: UserType2 = {
  email: "user01@test.org",
  name: "사용자01",
}

// user01.email = "user02@test.org" -> 수정 불가능
user01.name = "사용자02"

type UserType3 = {
  email: string
  name: string
}

type UserReadOnly = Readonly<UserType3>

const user03: UserReadOnly = {
  email: "user02@test.org",
  name: "사용자02",
}

// user03.email = '수정됨' -> 수정 불가
// user03.name = '안농'    -> 수정 불가
