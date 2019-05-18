package sample

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

open class Obstacle(x: Double, y: Double, private val width: Double, private val height: Double) {

  open val pos: Vector2 = Vector2(x, y)

  open fun draw(gtx: GraphicsContext) {
    gtx.fill = Color.WHITE
    gtx.fillRect(pos.x, pos.y, width, height)
  }

  fun checkCollision(insect: Insect) {
    if (insect.pos.y > pos.y && insect.pos.y < pos.y + height) {
      if (insect.pos.x >= pos.x && insect.pos.x <= pos
          .x + width) {
        insect.setCollision(true)
        //System.out.println("collision");
      }
    }
  }

}
