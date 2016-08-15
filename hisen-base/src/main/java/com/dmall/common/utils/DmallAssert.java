//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.utils;

import com.dmall.common.domain.PaymentException;
import java.util.Collection;
import java.util.Map;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public abstract class DmallAssert {
    public DmallAssert() {
    }

    public static void isTrue(boolean expression, String message) {
        if(!expression) {
            throw new PaymentException(message);
        }
    }

    public static void isTrue(boolean expression, String message, String code) {
        if(!expression) {
            throw new PaymentException(code, message);
        }
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    public static void isNull(Object object, String message) {
        if(object != null) {
            throw new PaymentException(message);
        }
    }

    public static void isNull(Object object, String message, String code) {
        if(object != null) {
            throw new PaymentException(code, message);
        }
    }

    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    public static void notNull(Object object, String message) {
        if(object == null) {
            throw new PaymentException(message);
        }
    }

    public static void notNull(Object object, String message, String code) {
        if(object == null) {
            throw new PaymentException(code, message);
        }
    }

    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void hasLength(String text, String message) {
        if(!StringUtils.hasLength(text)) {
            throw new PaymentException(message);
        }
    }

    public static void hasLength(String text, String message, String code) {
        if(!StringUtils.hasLength(text)) {
            throw new PaymentException(code, message);
        }
    }

    public static void hasLength(String text) {
        hasLength(text, "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    public static void hasText(String text, String message) {
        if(!StringUtils.hasText(text)) {
            throw new PaymentException(message);
        }
    }

    public static void hasText(String text, String message, String code) {
        if(!StringUtils.hasText(text)) {
            throw new PaymentException(code, message);
        }
    }

    public static void hasText(String text) {
        hasText(text, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    public static void doesNotContain(String textToSearch, String substring, String message) {
        if(StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch.contains(substring)) {
            throw new PaymentException(message);
        }
    }

    public static void doesNotContain(String textToSearch, String substring, String message, String code) {
        if(StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch.contains(substring)) {
            throw new PaymentException(code, message);
        }
    }

    public static void doesNotContain(String textToSearch, String substring) {
        doesNotContain(textToSearch, substring, "[Assertion failed] - this String argument must not contain the substring [" + substring + "]");
    }

    public static void notEmpty(Object[] array, String message) {
        if(ObjectUtils.isEmpty(array)) {
            throw new PaymentException(message);
        }
    }

    public static void notEmpty(Object[] array, String message, String code) {
        if(ObjectUtils.isEmpty(array)) {
            throw new PaymentException(code, message);
        }
    }

    public static void notEmpty(Object[] array) {
        notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void noNullElements(Object[] array, String message) {
        if(array != null) {
            Object[] arr$ = array;
            int len$ = array.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Object element = arr$[i$];
                if(element == null) {
                    throw new PaymentException(message);
                }
            }
        }

    }

    public static void noNullElements(Object[] array, String message, String code) {
        if(array != null) {
            Object[] arr$ = array;
            int len$ = array.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Object element = arr$[i$];
                if(element == null) {
                    throw new PaymentException(code, message);
                }
            }
        }

    }

    public static void noNullElements(Object[] array) {
        noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
    }

    public static void notEmpty(Collection collection, String message) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new PaymentException(message);
        }
    }

    public static void notEmpty(Collection collection, String message, String code) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new PaymentException(code, message);
        }
    }

    public static void notEmpty(Collection collection) {
        notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Map map, String message) {
        if(CollectionUtils.isEmpty(map)) {
            throw new PaymentException(message);
        }
    }

    public static void notEmpty(Map map, String message, String code) {
        if(CollectionUtils.isEmpty(map)) {
            throw new PaymentException(code, message);
        }
    }

    public static void notEmpty(Map map) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }

    public static void isInstanceOf(Class<?> clazz, Object obj) {
        isInstanceOf(clazz, obj, "");
    }

    public static void isInstanceOf(Class<?> type, Object obj, String message) {
        notNull(type, "Type to check against must not be null");
        if(!type.isInstance(obj)) {
            throw new PaymentException((StringUtils.hasLength(message)?message + " ":"") + "Object of class [" + (obj != null?obj.getClass().getName():"null") + "] must be an instance of " + type);
        }
    }

    public static void isInstanceOf(Class<?> type, Object obj, String message, String code) {
        notNull(type, "Type to check against must not be null");
        if(!type.isInstance(obj)) {
            throw new PaymentException(code, (StringUtils.hasLength(message)?message + " ":"") + "Object of class [" + (obj != null?obj.getClass().getName():"null") + "] must be an instance of " + type);
        }
    }

    public static void isAssignable(Class<?> superType, Class<?> subType) {
        isAssignable(superType, subType, "");
    }

    public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
        notNull(superType, "Type to check against must not be null");
        if(subType == null || !superType.isAssignableFrom(subType)) {
            throw new PaymentException(message + subType + " is not assignable to " + superType);
        }
    }

    public static void isAssignable(Class<?> superType, Class<?> subType, String message, String code) {
        notNull(superType, "Type to check against must not be null");
        if(subType == null || !superType.isAssignableFrom(subType)) {
            throw new PaymentException(code, message + subType + " is not assignable to " + superType);
        }
    }

    public static void state(boolean expression, String message) {
        if(!expression) {
            throw new PaymentException(message);
        }
    }

    public static void state(boolean expression, String message, String code) {
        if(!expression) {
            throw new PaymentException(code, message);
        }
    }

    public static void state(boolean expression) {
        state(expression, "[Assertion failed] - this state invariant must be true");
    }
}
