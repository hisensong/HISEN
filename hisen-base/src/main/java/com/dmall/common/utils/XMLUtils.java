//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.utils;

import com.thoughtworks.xstream.XStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XMLUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(XMLUtils.class);

    public XMLUtils() {
    }

    public static String obj2XML(Object object) {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        xStream.ignoreUnknownElements();
        return xStream.toXML(object);
    }

    public static Object XML2Obj(String xml, Class tClass) {
        XStream xStream = new XStream();
        xStream.processAnnotations(tClass);
        xStream.ignoreUnknownElements();
        return xStream.fromXML(xml);
    }

    public static void reflect(Object o) throws Exception {
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();

        for(int i = 0; i < fields.length; ++i) {
            Field f = fields[i];
            f.setAccessible(true);
        }

    }

    public static byte[] readInput(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        boolean len = false;
        byte[] buffer = new byte[1024];

        int len1;
        while((len1 = in.read(buffer)) > 0) {
            out.write(buffer, 0, len1);
        }

        out.close();
        in.close();
        return out.toByteArray();
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int i;
        while((i = is.read()) != -1) {
            baos.write(i);
        }

        return baos.toString();
    }

    public static InputStream getStringStream(String sInputString) throws UnsupportedEncodingException {
        ByteArrayInputStream tInputStringStream = null;
        if(sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes("UTF-8"));
        }

        return tInputStringStream;
    }

    /** @deprecated */
    @Deprecated
    public static Object getObjectFromXML(String xml, Class tClass) {
        XStream xStreamForResponseData = new XStream();
        xStreamForResponseData.alias("xml", tClass);
        xStreamForResponseData.ignoreUnknownElements();
        return xStreamForResponseData.fromXML(xml);
    }

    public static String getStringFromMap(Map<String, Object> map, String key, String defaultValue) {
        if(key != "" && key != null) {
            String result = (String)map.get(key);
            return result == null?defaultValue:result;
        } else {
            return defaultValue;
        }
    }

    public static int getIntFromMap(Map<String, Object> map, String key) {
        return key != "" && key != null?(map.get(key) == null?0:Integer.parseInt((String)map.get(key))):0;
    }

    public static String log(Object log) {
        LOGGER.info(log.toString());
        return log.toString();
    }

    public static Map<String, Object> modelToMap(Object obj) {
        HashMap result = new HashMap();

        for(Class clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            Object sb = null;

            for(int i = 0; i < fs.length; ++i) {
                if(!Modifier.isStatic(fs[i].getModifiers())) {
                    fs[i].setAccessible(true);

                    try {
                        Object e = fs[i].get(obj);
                        if(e != null) {
                            result.put(fs[i].getName(), String.valueOf(e));
                        }
                    } catch (Exception var7) {
                        var7.printStackTrace();
                    }
                }
            }
        }

        return result;
    }
}
