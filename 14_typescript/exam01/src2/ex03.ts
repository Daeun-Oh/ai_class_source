interface Point {
  x: number
  y: number
}

interface Point2 extends Point {
  z: number
}

function printPoint(point: Point2) {
  console.log(`x: ${point.x}, y: ${point.y}`)
}

printPoint({ x: 10, y: 20, z: 40 })
