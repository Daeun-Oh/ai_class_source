interface Point3 {
  x: number
  y: number
  printPoint: () => void
}

class MyPoint implements Point3 {
  x: number
  y: number

  constructor(x: number, y?: number) {
    this.x = x
    this.y = y
  }

  printPoint() {
    console.log(`x: ${this.x}, y: ${this.y}`)
  }
}

const my = new MyPoint(10)
my.printPoint
