package geek.lawsof.physics.lib.handler

import java.util.Random

import cpw.mods.fml.common.IWorldGenerator
import cpw.mods.fml.common.registry.GameRegistry
import geek.lawsof.physics.lib.block.BlockBase
import geek.lawsof.physics.lib.info.GenStats
import net.minecraft.block.Block
import net.minecraft.world.World
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.gen.feature.WorldGenMinable

import scala.collection.mutable

/**
 * NEEDS A Rework
 *
 * Created by anshuman on 28-05-2014.
 */
@Deprecated()
object WorldGenerator extends IWorldGenerator {
  GameRegistry.registerWorldGenerator(this, 0)

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

  var ores = mutable.HashMap.empty[BlockBase, GenStats]
}

