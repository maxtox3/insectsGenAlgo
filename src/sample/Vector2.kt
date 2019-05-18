package sample

class Vector2 {

  var x: Double = 0.toDouble()
  var y: Double = 0.toDouble()

  constructor() {
    this.x = 0.0
    this.y = 0.0
  }

  constructor(x: Double, y: Double) {
    this.x = x
    this.y = y
  }

  operator fun set(x: Double, y: Double) {
    this.x = x
    this.y = y
  }

  fun random(amount: Double) {
    this.x = Math.random() * (amount * 2) - amount
    this.y = Math.random() * (amount * 2) - amount
  }

  fun add(v: Vector2) {
    this.x += v.x
    this.y += v.y
  }

  fun add(x: Double, y: Double) {
    this.x += x
    this.y += y
  }

  override fun toString(): String {
    return String.format("(%.1f, %.1f)", x, y)
  }
}
