package qmech.helper;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import qmech.mod.Reference;
import cpw.mods.fml.common.FMLLog;

import static qmech.mod.Reference.*;

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
        logBase.logger = LogManager.getLogger(MOD_ID);
        return logBase;
    }

    public void log(Level logLevel, Object object) {

        logger.log(logLevel, object.toString());
    }

    public void info(Object object) {
        logger.info(object.toString());
    }
    public void debug(Object object) {
        logger.debug(object.toString());
    }
    public void fatal(Object object) {
        logger.fatal(object.toString());
    }
    public void error(Object object) {
        logger.error(object.toString());
    }
    public void fatal(Object object, Throwable error) {
        logger.fatal(object.toString(), error);
    }
    public void error(Object object, Throwable error) {
        logger.error(object.toString(), error);
    }
    public void trace(Object object) {
        logger.trace(object.toString());
    }

}