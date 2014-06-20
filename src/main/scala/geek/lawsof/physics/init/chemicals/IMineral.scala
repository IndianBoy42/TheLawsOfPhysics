package geek.lawsof.physics.init.chemicals

/**
 * Created by anshuman on 02-06-2014.
 */
trait IMineral extends ICompound{
  override def composition: Map[IIon, Int] = cations.asInstanceOf[Map[IIon,Int]] ++ anions.asInstanceOf[Map[IIon,Int]]

  def cations: Map[ICation, Int]

  def anions: Map[IAnion, Int]

  def processed = for (i <- 1 until anions.size) yield cations ++ (anions drop i)
}
