package qmech.lib.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static qmech.mod.Reference.MOD_ID;

public class LoggingHelper {

    private static LoggingHelper instance;
    private Logger logger;

    public static LoggingHelper getInstance() {
        if (instance != null) {
            return instance;
        }
        return construct();
    }

    private static LoggingHelper construct() {
        LoggingHelper logBase = new LoggingHelper();
        logBase.logger = LogManager.getLogger(MOD_ID);
        return logBase;
    }

    public void log(Level logLevel, Object object) {

        this.logger.log(logLevel, object.toString());
    }

    public void info(Object object) {
        this.logger.info(object.toString());
    }

    public void debug(Object object) {
        this.logger.debug(object.toString());
    }

    public void fatal(Object object) {
        this.logger.fatal(object.toString());
    }

    public void error(Object object) {
        this.logger.error(object.toString());
    }

    public void fatal(Object object, Throwable error) {
        this.logger.fatal(object.toString(), error);
    }

    public void error(Object object, Throwable error) {
        this.logger.error(object.toString(), error);
    }

    public void trace(Object object) {
        this.logger.trace(object.toString());
    }

}