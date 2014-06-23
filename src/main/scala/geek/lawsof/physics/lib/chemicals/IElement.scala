package geek.lawsof.physics.lib.chemicals

/**
 * Created by anshuman on 02-06-2014.
 */
trait IElement extends IIon {

  override def composition: Map[IElement, Int] = Map((this, 1))

}
