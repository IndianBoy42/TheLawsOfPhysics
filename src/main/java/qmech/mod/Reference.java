package qmech.mod;

import java.util.Arrays;
import java.util.List;


public class Reference {
    public static final String MOD_NAME = "Quantum Mechanization";
    public static final String MOD_ID = "qmechanization";
    public static final String MOD_VERSION = "0.0.0";
    
    public static final List<String> MOD_AUTHORS = Arrays.asList("GeckoTheGeek42", "ColdRock7", "Zarkoix", "Rein20/Trigalis");
    public static final String MOD_URL = "not yet sorry guys";
    public static final String MOD_DESCRIPTION = "A Realistic and Complex End-Game Technology Mod Based on Real Science Concepts";
    public static final String MOD_CREDITS = 
    		"All The People,\n "
    		+ "especially the forge teams for making minecraft modding possible and easy, \n"
    		+ "as well as wuppy29 and pahimar for being such awesome teachers";
    
    public static final String CLIENT_PROXY_CLASS = "test.mod.network.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "test.mod.network.CommonProxy";
    
    public static final String DEFAULT_CHANNEL = "LazyMod:Default";
    
    public static class Values {
    	
    	public static final int moltenMetalPerIngot = 144;
    	public static final int moltenMetalPerOre = moltenMetalPerIngot *2;
    	public static final int moltenMetalPerBlock = moltenMetalPerIngot *9;
    	public static final int moltenMetalPerNugget = moltenMetalPerIngot /2;
    	
    }
    
}

