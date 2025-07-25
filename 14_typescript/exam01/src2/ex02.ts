type Fruit = 'apple' | 'melon' | 'mango'  // 타입 리터럴 - 정해진 값 이외에는 들어올 수 없다.

function printFruit(item: Fruit) {
    console.log(item)
}

printFruit('mango')
//printFruit('orange') -> 오류남