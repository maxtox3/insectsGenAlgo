package sample

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class Target(x: Double, y: Double, private val w: Double, private val h: Double) :
  Obstacle(x, y, w, h) {

  override val pos: Vector2 = Vector2(x, y)

  override fun draw(gtx: GraphicsContext) {
    gtx.fill = Color.BLUE
    gtx.fillRect(pos.x - w / 2, pos.y - h / 2, w, h)
  }
}
