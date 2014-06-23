package geek.lawsof.physics.lib.handler

import cpw.mods.fml.common.IWorldGenerator
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.Block
import net.minecraft.world.gen.feature.WorldGenMinable
import net.minecraft.world.World
import net.minecraft.world.chunk.IChunkProvider
import java.util.Random
import geek.lawsof.physics.lib.info.GenStats
import geek.lawsof.physics.lib.helper.Log
import geek.lawsof.physics.lib.block.BlockBase

/**
 * Created by anshuman on 28-05-2014.
 */
object WorldGenerator {
  val default = new WorldGenerator()
}

class WorldGenerator(weight: Int) extends IWorldGenerator {
  GameRegistry.registerWorldGenerator(this, weight)

  def this() = this(0)

  def add(gen: BlockBase, stats: GenStats) {
    ores += (gen -> stats)
  }

  override def generate(rand: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkProvider, chunkProvider: IChunkProvider) {
    for (ore <- ores
         if world.provider.dimensionId == 0) {
      generateSurface(world, rand, chunkX * 16, chunkZ * 16, ore._1, ore._2)
    }
  }

  private def generateSurface(world: World, random: Random, i: Int, j: Int, oreBlock: Block, oreStats: GenStats) {
    for (k <- 1 to oreStats.maxVeinSpawn) {
      val firstBlockXCoord: Int = i + random.nextInt(16)
      val firstBlockYCoord: Int = oreStats.minY + random.nextInt(oreStats.diffY)
      val firstBlockZCoord: Int = j + random.nextInt(16)
      new WorldGenMinable(oreBlock, random.nextInt(oreStats.maxVeinSize)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord)
    }
  }

  var ores: Map[BlockBase, GenStats] = Map.empty
}

