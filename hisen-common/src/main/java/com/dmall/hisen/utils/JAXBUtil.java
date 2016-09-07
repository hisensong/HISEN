package com.dmall.hisen.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * JAXB操作工具类
 * 
 * @author zhaoqingyuan
 */
public class JAXBUtil {

	/**
	 * 读取xml解析
	 * 
	 * @param clazz 解析类型
	 * @param context 解析文件路径
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readString(Class<T> clazz, String context) throws JAXBException {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(new File(context));
		} catch (JAXBException e) {
			throw e;
		}
	}

	/**
	 * 生成xml格式数据
	 * @param obj
	 * @return
	 * @throws JAXBException
	 */
	public static String toXML(Object obj) throws JAXBException {
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			return writer.toString();
		} catch (JAXBException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T readConfig(Class<T> clazz, String config, Object... arguments)
			throws IOException, JAXBException {
		InputStream is = null;
		try {
			if (arguments.length > 0) {
				config = MessageFormat.format(config, arguments);
			}
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			is = new FileInputStream(config);
			return (T) u.unmarshal(is);
		} catch (IOException e) {
			throw e;
		} catch (JAXBException e) {
			throw e;
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T readConfigFromStream(Class<T> clazz, InputStream dataStream) throws JAXBException {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(dataStream);
		} catch (JAXBException e) {
			throw e;
		}
	}
}
