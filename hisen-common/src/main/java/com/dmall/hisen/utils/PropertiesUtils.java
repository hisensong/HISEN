package com.dmall.hisen.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static final Log LOG = LogFactory.getLog(PropertiesUtils.class);
    private Properties props = null;

    public synchronized void loads(String filename) {
        if (props == null) {
            InputStream is = PropertiesUtils.class.getResourceAsStream(filename);
            props = new Properties();
            try {
                props.load(is);
            } catch (Exception e) {
                LOG.error("Cannot load the properties from " + filename + ".");
            }
        }
    }
    
    public String getProperty(String key) {
        String value;
        
        try {
            value = props.getProperty(key);
        } catch (Exception e) {
            value = "";
        }
        
        if (value == null || value.length() == 0) {
            value = "";
        }
        
        LOG.debug(key + ":[" + value +"]");
        return value;
    }
    
    public Properties getProps() {
        return props;
    }
}
