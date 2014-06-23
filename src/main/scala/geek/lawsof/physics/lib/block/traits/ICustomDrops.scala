package geek.lawsof.physics.lib.block.traits

import java.util.Random
import net.minecraft.item.Item

/**
 * Created by anshuman on 22-06-2014.
 */
trait ICustomDrops {
  def quantityDropped(rand : Random): Int

  def quantityDroppedWithBonus(fortune : Int, random : Random): Int

  def getItemDropped(meta : Int, rand : Random, fortune : Int): Item

  def damageDropped(meta : Int): Int
}
