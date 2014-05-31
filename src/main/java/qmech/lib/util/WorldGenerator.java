package qmech.lib.util;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import qmech.mod.ModConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenerator implements IWorldGenerator {

    private final List<GenStats> oreGen = new ArrayList<GenStats>();
    private final List<Block> ores = new ArrayList<Block>();

    public WorldGenerator(int weight) {
        GameRegistry.registerWorldGenerator(this, weight);
    }

    public void add(Block gen, GenStats stats) {
        this.ores.add(gen);
        this.oreGen.add(ModConfig.getOreGenStats(gen.getLocalizedName(), stats.getMaxVeinSpawn(), stats.minY, stats.maxY, stats.getMaxVeinSize()));
    }

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        for (int i = 0; i < this.ores.size(); i++) {
            Block oreBlock = this.ores.get(i);
            GenStats oreStats = this.oreGen.get(i);
            switch (world.provider.dimensionId) {
                case -1:
                    break;
                case 0:
                    this.generateSurface(world, rand, chunkX * 16, chunkZ * 16, oreBlock, oreStats);
                    break;
                case 1:
                    break;
            }
        }
    }

    private void generateSurface(World world, Random random, int i, int j, Block oreBlock, GenStats oreStats) {
        if (!ModConfig.doOreGen) {
            return;
        }

        for (int k = 0; k < random.nextInt(oreStats.getMaxVeinSpawn()); k++) {
            int firstBlockXCoord = i + random.nextInt(16);
            int firstBlockYCoord = oreStats.minY + random.nextInt(oreStats.diffY);
            int firstBlockZCoord = j + random.nextInt(16);

            (new WorldGenMinable
                    (oreBlock, random.nextInt(oreStats.getMaxVeinSize()))
            ).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
    }

    public static class GenStats {

        int minY = 8;
        int maxY = 64;
        final int diffY = this.maxY - this.minY;
        int maxVeinSize = 8;
        int maxVeinSpawn = 8;
        public GenStats(int minHeight, int maxHeight, int maxVeinSize, int maxVeinSpawn) {
            this.minY = minHeight;
            this.maxY = maxHeight;
            this.maxVeinSize = maxVeinSize;
            this.maxVeinSpawn = maxVeinSpawn;
        }
        public GenStats() {
        }

        public void setMinY(int minY) {
            this.minY = minY;
        }

        public int getMaxY() {
            return this.maxY;
        }

        public void setMaxY(int maxY) {
            this.maxY = maxY;
        }

        public int getDiffY() {
            return this.diffY;
        }

        public int getMaxVeinSize() {
            return this.maxVeinSize;
        }

        public void setMaxVeinSize(int maxVeinSize) {
            this.maxVeinSize = maxVeinSize;
        }

        public int getMaxVeinSpawn() {
            return this.maxVeinSpawn;
        }

        public void setMaxVeinSpawn(int maxVeinSpawn) {
            this.maxVeinSpawn = maxVeinSpawn;
        }

    }
}
