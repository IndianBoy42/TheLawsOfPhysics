package geek.lawsof.physics.lib.chemicals.traits

/**
 * Created by anshuman on 02-06-2014.
 */
trait IIon {

  //def valency: Int

  //true = +ve
  //false = -ve
  def charge: Boolean

  def composition: Map[IElement, Int]

  def symbol: String

  def name: String

  override def toString: String = {
    var str: String = s"$name ($symbol) : "
    for (entry: (IElement, Int) <- composition) {
      str += s"${entry._1.symbol}${entry._2}"
    }
    str
  }
}

trait ICation extends IIon {
  //true = +ve
  override def charge: Boolean = true
}

trait IAnion extends IIon {
  //false = -ve
  override def charge: Boolean = false
}