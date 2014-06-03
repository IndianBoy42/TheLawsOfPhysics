package qmech.mod.init

import net.minecraftforge.common.config.Configuration
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import qmech.lib.objects.BlockBase
import QMechanization
import qmech.lib.objects.info.BlockInfo

object ModConfigs {
  var cfg: Configuration = null
  var FEATURES: String = "Features"
  var FEATURES_COMMENTS: String = "Enable/Disable Mod Features"
  var doOreGen: Boolean = true

  def preInit() {
    cfg = create(QMechanization.preInit)
    cfg.load()
    createCategory(FEATURES, FEATURES_COMMENTS)
    doOreGen = cfg.get(FEATURES, "Should Do Ore Generation", doOreGen, "Should Quantum Mechanization Generate Ores\n" + "Disable If Some Other Mod Handles Ore Generation For Your Mod Pack").getBoolean(doOreGen)
    cfg.save()
  }

  def create(evt: FMLPreInitializationEvent): Configuration = {
    val configuration: Configuration = new Configuration(evt.getSuggestedConfigurationFile)
    configuration
  }

  def createCategory(name: String, comment: String) {
    cfg.addCustomCategoryComment(name, comment)
  }

  //  def getOreGenStats(oreName: String, maxFreq: Int, minHeight: Int, maxHeight: Int, maxVein: Int): WorldGenerator.GenStats = {
  //    cfg.load
  //    val stats: WorldGenerator.GenStats = new WorldGenerator.GenStats
  //    createCategory(String.format("ores.%s", oreName), String.format("Ore Generation Statistics For %s", oreName))
  //    stats.setMaxVeinSpawn(cfg.get(String.format("ores.%s", oreName), "Maximum Frequency Per Chunk", maxFreq).getInt(maxFreq))
  //    stats.setMaxY(cfg.get(String.format("ores.%s", oreName), "Maximum Height", maxHeight).getInt(maxHeight))
  //    stats.setMinY(cfg.get(String.format("ores.%s", oreName), "Minimum Height", minHeight).getInt(minHeight))
  //    stats.setMaxVeinSize(cfg.get(String.format("ores.%s", oreName), "Maximum Vein Size", maxVein).getInt(maxVein))
  //    cfg.save
  //    return stats
  //  }

  def getBlockInfo(blokk: BlockBase, hard: Float, blast: Float, tool: String, lvl: Int): BlockInfo = {
    cfg.load()
    val block: BlockInfo = new BlockInfo
    createCategory(s"blocks.${blokk.getUnlocalizedName.substring(5)}", s"Block Information For ${blokk.getLocalizedName}")
    block.blastResistance = cfg.get(s"block.${blokk.getUnlocalizedName.substring(5)}", "Blast Resistance", blast).getDouble(blast).asInstanceOf[Float]
    block.hardness = cfg.get(s"block.${blokk.getUnlocalizedName.substring(5)}", "Hardness", hard).getDouble(hard).asInstanceOf[Float]
    block.toolType = cfg.get(s"block.${blokk.getUnlocalizedName.substring(5)}", "Tool Harvest Type", tool).getString
    block.toolLevel = cfg.get(s"block.${blokk.getUnlocalizedName.substring(5)}", "Tool Harvest Level", lvl).getInt(lvl)
    cfg.save()
    block
  }

  def getBlockInfo(blokk: BlockBase, nfo: BlockInfo): BlockInfo = {
    getBlockInfo(blokk, nfo.hardness, nfo.blastResistance, nfo.toolType, nfo.toolLevel)
  }
}
