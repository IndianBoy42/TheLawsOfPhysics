package lawsof.physics.mod.content.chemicals

/**
 * Created by anshuman on 02-06-2014.
 */
trait ICompound {

  def composition: Map[IIon, Int]

  override def toString: String = {
    var str: String = "null"
    for (entry <- composition) {
      str += s"${entry._1}${entry._2}"
    }
    str
  }

}
