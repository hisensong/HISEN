package com.hisen.task.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by gaoang on 2016/12/13.
 */
public class ServiceDaoImpl extends JdbcDaoSupport implements ServiceDao {
    private static Log LOG = LogFactory.getLog(ServiceDaoImpl.class);

    @Override
    public void moveData() throws Exception {
        long begin = System.currentTimeMillis();
        int pageSize = 6000;
        int deleteSize = 2000;
        File idFiles = new File("ids.txt");
        if (idFiles.exists()) {
            idFiles.delete();
            idFiles = new File("ids.txt");
        }
        FileWriter fr = new FileWriter(idFiles);
        LOG.info("----------------------------start------------------------------------");
        String countSql = "SELECT COUNT(1) AS total FROM t_service_procedure AS p JOIN t_service_define d ON p.`service_code` = d.`service_code` " +
                "WHERE TIMESTAMPDIFF(DAY, p.`req_date`, NOW()) >= d.`exp_date`";
        int i = 0;
        try {
            Integer total = this.getJdbcTemplate().queryForObject(countSql, Integer.class);
            if (total != null && total != 0) {
                int page=(total % pageSize == 0)?(total / pageSize):(total / pageSize + 1);
                for (; i < page; i++) {
                    int start = pageSize * i;
                    //分页查询id
                    String selectSql = "SELECT p.id FROM t_service_procedure AS p JOIN t_service_define d ON p.`service_code` = d.`service_code` " +
                            "WHERE TIMESTAMPDIFF(DAY, p.`req_date`, NOW()) >= d.`exp_date` ORDER BY id DESC limit " + start + "," + pageSize;
                    long queryStart = System.currentTimeMillis();
                    List<Integer> integers = this.getJdbcTemplate().queryForList(selectSql, Integer.class);
                    LOG.info("第[" + i + "]页共" + integers.size()+"条数据,查询用时:"+(System.currentTimeMillis()-queryStart)/1000.0);

                    String sql1 = "INSERT IGNORE INTO t_service_procedure_history \n" +
                            "  SELECT " +
                            "    p.`id`," +
                            "    p.`biz_no`," +
                            "    p.`service_code`," +
                            "    p.`channel`," +
                            "    p.`uid`," +
                            "    p.`message`," +
                            "    p.`req_date`," +
                            "    p.`req_time`," +
                            "    p.`res_time`," +
                            "    p.`query_stat`," +
                            "    p.`get_stat` " +
                            "  FROM " +
                            "    t_service_procedure p " +
                            "  WHERE p.id in ( " + this.convertToCommaSeparatedList(integers) + ")";
                    long startTime = System.currentTimeMillis();
                    this.getJdbcTemplate().execute(sql1);
                    LOG.info("导出第["+i+"]页数据成功，用时:"+(System.currentTimeMillis()-startTime)/1000.0+"s");
                    for (Integer id : integers) {
                        fr.write(id + "\n");
                        fr.flush();
                    }
                    LOG.info("写入第"+i+"页id到文件ids.txt成功!");
                }
                fr.close();
            }
        } catch (Exception e) {
            LOG.error("导出数据出错 当前页数 : " + i + "页", e);
            idFiles.delete();
            return;
        }

        File readIdsFile = new File("ids.txt");
        int index = 0;
        try {
            if (readIdsFile.exists()) {
                FileReader freader = new FileReader(readIdsFile);
                BufferedReader br = new BufferedReader(freader);
                List<Integer> ids = new ArrayList<Integer>();
                String line = null;

                while ((line = br.readLine()) != null) {
                    ids.add(Integer.valueOf(line));
                    if (ids.size() == deleteSize) {
                        //删除
                        index++;
                        String sql2 = "DELETE " +
                                "  FROM" +
                                "    t_service_procedure " +
                                "  WHERE t_service_procedure.id IN (" + this.convertToCommaSeparatedList(ids) + ")";
                        LOG.info("删除第["+index+"]页数据...");
                        long startTime2 = System.currentTimeMillis();
                        this.getJdbcTemplate().execute(sql2);
                        LOG.info("删除第["+index+"]页数据成功，用时："+(System.currentTimeMillis()-startTime2)/1000.0+"s");

                        ids.clear();
                    }
                }
                if (ids.size() != 0) {
                    //删除
                    index++;
                    String sql2 = "DELETE " +
                            "  FROM" +
                            "    t_service_procedure " +
                            "  WHERE t_service_procedure.id IN (" + this.convertToCommaSeparatedList(ids) + ")";
                    LOG.info("删除第["+index+"]页数据...");
                    long startTime2 = System.currentTimeMillis();
                    this.getJdbcTemplate().execute(sql2);
                    LOG.info("删除第["+index+"]页数据成功，用时："+(System.currentTimeMillis()-startTime2)/1000.0+"s");
                }
            }
        } catch (Exception e){
            LOG.error("删除数据出错",e);
        } finally {
            LOG.info("总用时:"+(System.currentTimeMillis()-begin)/1000.0);
           readIdsFile.delete();
        }
        LOG.info("----------------------------end------------------------------------");
    }

    private String convertToCommaSeparatedList(List<Integer> items) {
        StringBuilder output = new StringBuilder();
        for (Integer item : items) {
            output.append(item + ",");
        }
        // Remove leading comma, if the list is not empty.
        if (output.length() != 0) {
            output.deleteCharAt(output.length() - 1);
        }
        return output.toString();
    }
}
