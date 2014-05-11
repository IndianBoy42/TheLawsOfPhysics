package qmech.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import qmech.mod.Reference;
import cpw.mods.fml.common.FMLLog;

public class LoggingHelper {

    private Logger logger;
    
    static LoggingHelper instance;

    public static LoggingHelper getInstance() {
    	if (instance != null) {
			return instance;
		}
		return construct();
    }
    
    public static LoggingHelper construct () {
    	LoggingHelper logBase = new LoggingHelper();
        logBase.logger = Logger.getLogger(Reference.MOD_ID);
        logBase.logger.setParent((Logger) FMLLog.getLogger());
        return logBase;
    }

    public void log(Level logLevel, Object object) {

        logger.log(logLevel, object.toString());
    }

    public void severe(Object object) {

        log(Level.SEVERE, object.toString());
    }
    
    public void debug(Object object) {
    	
        log(Level.INFO, "[DEBUG] " + object.toString());
    }

    public void warning(Object object) {

        log(Level.WARNING, object.toString());
    }

    public void info(Object object) {

        log(Level.INFO, object.toString());
    }

    public void config(Object object) {

        log(Level.CONFIG, object.toString());
    }

    public void fine(Object object) {

        log(Level.FINE, object.toString());
    }

    public void finer(Object object) {

        log(Level.FINER, object.toString());
    }

    public void finest(Object object) {

        log(Level.FINEST, object.toString());
    }
}