package com.hisen.task.run;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.management.ManagementFactory;


/**
 * Description:
 * Created by gaoang on 2016/12/13.
 */
public class Main {
    private static final Log LOG = LogFactory.getLog(Main.class);
    public static void main(String[] args) {
        try {
            String pid = writePID();
            LOG.info("gcsp-task start...[PID] "+pid);
            ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-root.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static String writePID() throws IOException {
        File f = new File("device.pid");
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        String pid = processName.substring(0, processName.indexOf("@"));
        writer.write(String.valueOf(pid));
        writer.flush();
        writer.close();
        return pid;
    }
}