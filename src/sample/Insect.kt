package sample

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class Insect {

  val pos: Vector2
  private val vel: Vector2
  val acc: Vector2
  private var collision = false

  var dna: DNA? = null

  var fintess: Double = 0.toDouble()

  constructor(lifeSpan: Int) {
    this.pos = Vector2(10.0, MainScreen.height / 2)
    this.vel = Vector2()
    this.acc = Vector2()
    this.dna = DNA(lifeSpan)
  }

  constructor(lifeSpan: Int, alreadyHasDNA: Boolean) {
    this.pos = Vector2(10.0, MainScreen.height / 2)
    this.vel = Vector2()
    this.acc = Vector2()
  }


  fun move(force: Vector2) {
    acc.add(force)
  }


  fun calculateFitness(target: Target) {

    val x1 = pos.x
    val x2 = target.pos.x
    val y1 = pos.y
    val y2 = target.pos.y

    //Расстояние между двумя точками находится по формуле AB = √(xb - xa)^2 + (yb - ya)^2
    //pow - возведение в степерь
    val distance = Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0))

    //todo важно! коэффициент фитнесс функции -  от 0 до 1
    this.fintess = 1 / distance
  }

  fun setCollision(collision: Boolean) {
    this.collision = collision
  }

  fun update(counter: Int) {
    var counter = counter


    if (pos.x < 0 || pos.x > 1900 || pos.y < 0 || pos.y > 1000) {
      collision = true

    }

    if (collision) {
      this.vel.set(0.0, 0.0)
      this.acc.set(0.0, 0.0)
    } else {
      move(dna!!.genes[counter])

      this.vel.add(this.acc)
      this.pos.add(this.vel)
      this.acc.set(0.0, 0.0)
    }

    counter++
  }

  fun draw(gtx: GraphicsContext) {
    gtx.fill = Color.RED
    gtx.fillOval(pos.x, pos.y, 5.0, 5.0)
  }
}
