package com.hisen.task.bo.crontask;

import com.hisen.task.service.MoveDataService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/8/19 17:10
 */
@Service
public class ProceCronService {

    private static Log LOG = LogFactory.getLog(ProceCronService.class);

    private MoveDataService moveDataService;

    public MoveDataService getMoveDataService() {
        return moveDataService;
    }

    public void setMoveDataService(MoveDataService moveDataService) {
        this.moveDataService = moveDataService;
    }

    public void task(){
        LOG.info("开始数据迁移");
        try {
            moveDataService.moveData();
        } catch (Exception e) {
            LOG.error("数据迁移错误",e);
            e.printStackTrace();
        }
        LOG.info("数据迁移结束");
    }

    public void test(){
        LOG.info("测试定时任务");
    }

}
