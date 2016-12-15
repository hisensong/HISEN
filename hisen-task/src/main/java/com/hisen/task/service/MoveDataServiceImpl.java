package com.hisen.task.service;


import com.hisen.task.dao.ServiceDao;
import com.hisen.task.dao.ServiceDaoImpl;

/**
 * Description:
 * Created by gaoang on 2016/12/13.
 */
public class MoveDataServiceImpl implements MoveDataService{
    private ServiceDao serviceDao;

    public void setServiceDao(ServiceDaoImpl serviceDao) {
        this.serviceDao = serviceDao;
    }

    public ServiceDao getServiceDao() {
        return serviceDao;
    }

    @Override
    public void moveData() throws Exception{
        serviceDao.moveData();
    }
}
