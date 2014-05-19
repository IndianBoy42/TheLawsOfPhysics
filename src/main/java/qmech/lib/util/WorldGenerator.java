package qmech.lib.util;

import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import qmech.lib.objects.BlockBase;
import qmech.mod.ModConfig;

public class WorldGenerator implements IWorldGenerator {
	
	public static class GenStats {
		
	    public GenStats(int minHeight, int maxHeight, int maxVeinSize, int maxVeinSpawn) {
			this.minY = minHeight;
	    	this.maxY = maxHeight;
			this.maxVeinSize = maxVeinSize;
			this.maxVeinSpawn = maxVeinSpawn;
		}

        public GenStats() {}
	    
	    int minY = 8;
		int maxY = 64;
		int diffY = maxY - minY;
	    int maxVeinSize = 8;
	    int maxVeinSpawn = 8;

        public void setMinY(int minY) {
            this.minY = minY;
        }

        public void setMaxY(int maxY) {
            this.maxY = maxY;
        }

        public void setMaxVeinSize(int maxVeinSize) {
            this.maxVeinSize = maxVeinSize;
        }

        public void setMaxVeinSpawn(int maxVeinSpawn) {
            this.maxVeinSpawn = maxVeinSpawn;
        }

        public int getMaxY() {
			return maxY;
		}
		public int getDiffY() {
			return diffY;
		}
		public int getMaxVeinSize() {
			return maxVeinSize;
		}
		public int getMaxVeinSpawn() {
			return maxVeinSpawn;
		}
	    
	}
	
	public WorldGenerator (int weight) {
		GameRegistry.registerWorldGenerator(this, weight);
	}

    List<GenStats> oreGen = new ArrayList<GenStats>();
    List<Block> ores = new ArrayList<Block>();
	
	public void add (Block gen, GenStats stats) {
		ores.add(gen);
        oreGen.add(ModConfig.getOreGenStats(gen.getLocalizedName(), stats.getMaxVeinSpawn(), stats.minY, stats.maxY, stats.getMaxVeinSize()));
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int i = 0; i<ores.size(); i++) {
            Block oreBlock = ores.get(i);
            GenStats oreStats = oreGen.get(i);
	    	switch(world.provider.dimensionId){
	        case -1:
	            break;
	        case 0:
	            generateSurface(world, rand, chunkX * 16, chunkZ * 16, oreBlock, oreStats);
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

        for (int k=0; k<random.nextInt(oreStats.getMaxVeinSpawn()); k++) {
        	int firstBlockXCoord = i + random.nextInt(16);
        	int firstBlockYCoord = oreStats.minY + random.nextInt(oreStats.diffY);
        	int firstBlockZCoord = j + random.nextInt(16);
        	
        	(new WorldGenMinable 
        			(oreBlock, random.nextInt(oreStats.getMaxVeinSize()))
        		).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
	}
}
