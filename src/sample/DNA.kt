package sample

class DNA {

  private var lifeSpan: Int = 0
  var genes: Array<Vector2> = arrayOf()

  constructor(lifeSpan: Int) {
    this.lifeSpan = lifeSpan
    init()
  }

  constructor(lifeSpan: Int, genes: Array<Vector2>) {
    this.lifeSpan = lifeSpan
    this.genes = genes
  }

  private fun init() {
    genes = Array(lifeSpan) { Vector2() }
    for (i in genes.indices) {
      genes[i] = Vector2()
      genes[i].random(1.0)
    }
  }

  fun crossOver(parentB: DNA): DNA {

    val newGenes = Array(lifeSpan) { Vector2() }
    val mid = Math.random() * genes.size
    for (i in genes.indices) {
      if (i > mid) {
        newGenes[i] = genes[i]
      } else {
        newGenes[i] = parentB.genes[i]
      }
    }
    return DNA(lifeSpan, newGenes)
  }
}
