package sample

import java.util.ArrayList

import javafx.scene.paint.Color

class Logic(private val mainScreen: MainScreen) {

  private val lifeSpan = 400
  private val size = 7000
  private var population: Population? = null
  private val target: Target
  private val obstacles: MutableList<Obstacle>


  private var counter: Int = 0

  init {
    //создаем популяцию
    this.population = Population(size, lifeSpan)
    //создаем финиш, куда будут пытаться добраться мошки
    this.target = Target(1300.0, MainScreen.height / 2, 50.0, 50.0)
    //создаем и рисуем препятствия
    this.obstacles = ArrayList()
    obstacles.add(target)
    for (i in 0..9) {
      val x = Math.random() * MainScreen.width + 50
      val y = Math.random() * MainScreen.height
      val w = 100.0
      val h = Math.random() * 350
      obstacles.add(Obstacle(x, y, w, h))
    }

    counter = 0


  }

  fun update() {

    population!!.insects.forEach { i ->
      i.update(counter)
      obstacles.forEach { o -> o.checkCollision(i) }
    }


    if (counter == lifeSpan - 1) {
      counter = 0

      population!!.evaluate(target)
      val newPop = Population(size, lifeSpan, population!!.selection())
      this.population = newPop
    } else {
      counter++

    }

  }

  fun draw() {
    mainScreen.clearScreen()
    population!!.insects.forEach { i ->
      i.draw(mainScreen.gtx)
      mainScreen.gtx.stroke = Color.rgb(0, 0, 255, .5)
    }

    target.draw(mainScreen.gtx)
    obstacles.forEach { o -> o.draw(mainScreen.gtx) }
  }

}
