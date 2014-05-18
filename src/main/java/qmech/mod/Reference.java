package qmech.mod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import qmech.mod.network.ClientProxy;
import qmech.mod.network.CommonProxy;

import java.util.Arrays;
import java.util.List;


public class Reference {

    public static final String MOD_NAME = "QuantumMechanization";
    public static final String MOD_ID = "qmechanization";
    public static final String MOD_VERSION = "0.0.0";
    
    public static final List<String> MOD_AUTHORS = Arrays.asList("GeckoTheGeek42", "ColdRock7", "Zarkoix", "Rein20/Trigalis");
    public static final String MOD_URL = "not yet sorry guys";
    public static final String MOD_DESCRIPTION = "A Realistic and Complex End-Game Technology Mod Based on Real Science Concepts";
    public static final String MOD_CREDITS = 
    		"All The People,\n ";
    
    public static final String CLIENT_PROXY_CLASS = "qmech.mod.network.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "qmech.mod.network.CommonProxy";

    public static final int RENDER_ID = RenderingRegistry.getNextAvailableRenderId();

    public static class Values {
    	
    	public static final int moltenMetalPerIngot = 144;
    	public static final int moltenMetalPerOre = moltenMetalPerIngot *2;
    	public static final int moltenMetalPerBlock = moltenMetalPerIngot *9;
    	public static final int moltenMetalPerNugget = moltenMetalPerIngot /2;
    	
    }

    public static final String TEXTURES_BLOCKS = "textures/blocks";
    public static final String TEXTURES_ITEMS = "textures/metalItems";
    public static final String TEXTURES_MODELS = "textures/models";
    public static final String TEXTURES_GUI = "textures/gui";
    public static final String TEXTURES_EQUIP = "textures/equip";
    
}

