//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.utils;

import com.dmall.common.domain.BaseMsgException;
import com.dmall.common.utils.DateFormatUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public class BeanHelper extends BeanUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanHelper.class);

    public BeanHelper() {
    }

    public static <T> Collection<T> copyTo(Collection<?> sourceList, Class<T> target) {
        if(CollectionUtils.isEmpty(sourceList)) {
            return Collections.emptyList();
        } else {
            ArrayList list = new ArrayList();

            try {
                Iterator e = sourceList.iterator();

                while(e.hasNext()) {
                    Object o = e.next();
                    list.add(copyTo(o, target));
                }

                return list;
            } catch (Exception var5) {
                LOGGER.error("数组复制出现错误source=[{}],targetType=[{}],errMsg=[{}]", new Object[]{sourceList, target, var5.getMessage()});
                throw new BaseMsgException(var5.getMessage());
            }
        }
    }

    public static <T> T copyTo(Object sourceObj, Class<T> target) {
        if(sourceObj == null) {
            return null;
        } else {
            try {
                Object e = target.newInstance();
                BeanUtils.copyProperties(sourceObj, e);
                return (T)e;
            } catch (Exception var3) {
                LOGGER.error("对象复制出现错误source=[{}],targetType=[{}],errMsg=[{}]", new Object[]{sourceObj, target, var3.getMessage()});
                throw new BaseMsgException(var3.getMessage());
            }
        }
    }

    public static Map<String, Object> modelToMap(Object obj, String prefix, String suffix) {
        HashMap result = new HashMap();

        for(Class clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            StringBuffer sb = null;

            for(int i = 0; i < fs.length; ++i) {
                if(!Modifier.isStatic(fs[i].getModifiers())) {
                    fs[i].setAccessible(true);

                    try {
                        Object e = fs[i].get(obj);
                        if(e != null) {
                            sb = (new StringBuffer(StringUtils.isBlank(prefix)?"":prefix)).append(fs[i].getName()).append(StringUtils.isBlank(suffix)?"":suffix);
                            result.put(sb.toString(), e);
                        }
                    } catch (Exception var9) {
                        LOGGER.error("对象转map出现错误source=[{}],prefix=[{}],suffix=[{}],errMsg=[{}]", new Object[]{obj, prefix, suffix, var9.getMessage()});
                        throw new BaseMsgException(var9.getMessage());
                    }
                }
            }
        }

        return result;
    }

    public static Map<String, String> modelToMap(Object obj) {
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
                        LOGGER.error("对象转map出现错误source=[{}],errMsg=[{}]", new Object[]{obj, var7.getMessage()});
                        throw new BaseMsgException(var7.getMessage());
                    }
                }
            }
        }

        return result;
    }

    public static Object mapToModel(Map<String, String> map, Class<?> clazz) {
        Object result = null;
        Set keySet = map.keySet();

        try {
            for(result = clazz.newInstance(); clazz != Object.class; clazz = clazz.getSuperclass()) {
                Iterator e = keySet.iterator();

                while(e.hasNext()) {
                    String attr = (String)e.next();
                    Field field = null;

                    try {
                        field = clazz.getDeclaredField(attr);
                    } catch (NoSuchFieldException var12) {
                        continue;
                    }

                    field.setAccessible(true);
                    Class typeClazz = field.getType();
                    Object o = map.get(attr);
                    if(o != null) {
                        String dateType;
                        if(typeClazz.equals(String.class)) {
                            dateType = o.toString();
                            field.set(result, dateType);
                        } else if(typeClazz.equals(Integer.class)) {
                            field.set(result, Integer.valueOf(Integer.parseInt(o.toString())));
                        } else if(typeClazz.equals(Long.class)) {
                            field.set(result, Long.valueOf(Long.parseLong(o.toString())));
                        } else if(typeClazz.equals(Date.class)) {
                            dateType = DateFormatUtils.getFormat(o.toString());
                            Date date;
                            if(dateType != null) {
                                SimpleDateFormat calendar = new SimpleDateFormat(dateType);
                                date = calendar.parse(o.toString());
                                field.set(result, date);
                            } else {
                                Calendar calendar1 = Calendar.getInstance();
                                calendar1.setTimeInMillis(Long.parseLong(o.toString()));
                                date = calendar1.getTime();
                                field.set(result, date);
                            }
                        } else if(typeClazz.equals(Float.class)) {
                            field.set(result, Float.valueOf(Float.parseFloat(o.toString())));
                        } else if(typeClazz.equals(Double.class)) {
                            field.set(result, Double.valueOf(Double.parseDouble(o.toString())));
                        }
                    }
                }
            }

            return result;
        } catch (Exception var13) {
            LOGGER.error("map转对象出现错误source=[{}],targetType=[{}],errMsg=[{}]", new Object[]{map, clazz, var13.getMessage()});
            throw new BaseMsgException(var13.getMessage());
        }
    }

    public static <T> Class<T> findParameterizedType(Class<?> clazz, int index) {
        Type parameterizedType = clazz.getGenericSuperclass();
        if(!(parameterizedType instanceof ParameterizedType)) {
            parameterizedType = clazz.getSuperclass().getGenericSuperclass();
        }

        if(!(parameterizedType instanceof ParameterizedType)) {
            return null;
        } else {
            Type[] actualTypeArguments = ((ParameterizedType)parameterizedType).getActualTypeArguments();
            return actualTypeArguments != null && actualTypeArguments.length != 0 && index <= actualTypeArguments.length?(Class)actualTypeArguments[index]:null;
        }
    }

    public static <T extends Serializable> T clone(T obj) {
        Serializable clonedObj = null;

        try {
            ByteArrayOutputStream e = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(e);
            oos.writeObject(obj);
            oos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(e.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clonedObj = (Serializable)ois.readObject();
            ois.close();
            return (T)clonedObj;
        } catch (Exception var6) {
            LOGGER.error("数据复制出现错误source=[{}],errMsg=[{}]", new Object[]{obj, var6.getMessage()});
            throw new BaseMsgException(var6.getMessage());
        }
    }
}
