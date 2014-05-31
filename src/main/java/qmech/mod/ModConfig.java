package qmech.mod;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import qmech.lib.objects.BlockBase;
import qmech.lib.util.WorldGenerator;

/**
 * Created by anshuman on 17-05-2014.
 */
public class ModConfig {

    private static Configuration cfg;

    //category
    private static final String FEATURES = "Features";
    private static final String FEATURES_COMMENTS = "Enable/Disable Mod Features";

    //configs
    public static boolean doOreGen = true;

    public static void preInit() {
        cfg = create(ModBase.getInstance().event_preInit);
        cfg.load();

        createCategory(FEATURES, FEATURES_COMMENTS);

        doOreGen = cfg.get(FEATURES, "Should Do Ore Generation", doOreGen,
                "Should Quantum Mechanization Generate Ores\n" +
                        "Disable If Some Other Mod Handles Ore Generation For Your Mod Pack"
        )
                .getBoolean(doOreGen);

        cfg.save();
    }

    private static Configuration create(FMLPreInitializationEvent evt) {
        return new Configuration(evt.getSuggestedConfigurationFile());
    }

    private static void createCategory(String name, String comment) {
        cfg.addCustomCategoryComment(name, comment);
    }

    public static WorldGenerator.GenStats getOreGenStats(String oreName, int maxFreq, int minHeight, int maxHeight, int maxVein) {
        cfg.load();

        WorldGenerator.GenStats stats = new WorldGenerator.GenStats();

        createCategory(String.format("ores.%s", oreName), String.format("Ore Generation Statistics For %s", oreName));

        stats.setMaxVeinSpawn(cfg.get(String.format("ores.%s", oreName), "Maximum Frequency Per Chunk", maxFreq).getInt(maxFreq));
        stats.setMaxY(cfg.get(String.format("ores.%s", oreName), "Maximum Height", maxHeight).getInt(maxHeight));
        stats.setMinY(cfg.get(String.format("ores.%s", oreName), "Minimum Height", minHeight).getInt(minHeight));
        stats.setMaxVeinSize(cfg.get(String.format("ores.%s", oreName), "Maximum Vein Size", maxVein).getInt(maxVein));

        cfg.save();

        return stats;
    }

    public static BlockBase.BlockInfo getBlockInfo(BlockBase blokk, float hard, float blast, String tool, int lvl) {
        cfg.load();

        BlockBase.BlockInfo block = new BlockBase.BlockInfo();

        createCategory(String.format("blocks.%s", blokk.getUnlocalizedName().substring(5)), String.format("Block Information For %s", blokk.getLocalizedName()));

        block.blastResistance = (float) cfg.get(String.format("block.%s", blokk.getUnlocalizedName().substring(5)), "Blast Resistance", blast).getDouble(blast);
        block.hardness = (float) cfg.get(String.format("block.%s", blokk.getUnlocalizedName().substring(5)), "Hardness", hard).getDouble(hard);
        block.toolType = cfg.get(String.format("block.%s", blokk.getUnlocalizedName().substring(5)), "Tool Harvest Type", tool).getString();
        block.toolLevel = cfg.get(String.format("block.%s", blokk.getUnlocalizedName().substring(5)), "Tool Harvest Level", lvl).getInt(lvl);

        cfg.save();

        return block;
    }

    public static BlockBase.BlockInfo getBlockInfo(BlockBase blokk, BlockBase.BlockInfo nfo) {
        return getBlockInfo(blokk, nfo.hardness, nfo.blastResistance, nfo.toolType, nfo.toolLevel);
    }

}
