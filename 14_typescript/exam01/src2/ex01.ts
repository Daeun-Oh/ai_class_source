type userType = {
    email: string
    name: string
}

let user01 = {
    email: 'user01@test.org',
    name: '사용자01',
}

user01 = user01 as userType
delete user01.email
console.log(user01)