package qmech.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.*;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigHelper {
    
    Configuration configFile;
    
    public ConfigHelper (FMLPreInitializationEvent event) {
        configFile = new Configuration(event.getSuggestedConfigurationFile());
        configFile.load();
    }
    
    public ConfigHelper (File file) {
    	configFile = new Configuration(file);
    }
    
    public Configuration config () {
        return configFile;
    }
    public void saveConfigFile () {
    	configFile.save();
    }
    
    public List<Integer> getOreGenStats (String oreName, int maxFreq, int minFreq, int height, int maxVein, int minVein) {
    	List<Integer> stats = new ArrayList<Integer>();
    	
    	stats.add(configFile.get(String.format("Ore Generation Statistics - %s", oreName), "Maximum Frequency Per Chunk", maxFreq).getInt(maxFreq));
    	stats.add(configFile.get(String.format("Ore Generation Statistics - %s", oreName), "Minimum Frequency Per Chunk", minFreq).getInt(minFreq));
    	stats.add(configFile.get(String.format("Ore Generation Statistics - %s", oreName), "Maximum Height", height).getInt(height));
    	stats.add(configFile.get(String.format("Ore Generation Statistics - %s", oreName), "Maximum Vein Size", maxVein).getInt(maxVein));
    	stats.add(configFile.get(String.format("Ore Generation Statistics - %s", oreName), "Minimum Vein Size", minVein).getInt(minVein));
    	
    	return stats;
    }
}
