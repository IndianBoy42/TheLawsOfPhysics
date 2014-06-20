package geek.lawsof.physics.lib.objects.info

/**
 * Created by anshuman on 28-05-2014.
 */
class GenStats(val minY: Int = 8, val maxY: Int = 64, val maxVeinSize: Int = 8, val maxVeinSpawn: Int = 8) {
  def diffY = maxY - minY
}
