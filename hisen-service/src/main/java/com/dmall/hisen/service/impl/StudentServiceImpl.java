package com.dmall.hisen.service.impl;

import com.dmall.hisen.dao.StudentDao;
import com.dmall.hisen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Company:国美小额贷款有限公司
 * Author:HisenSong
 * DateTime: 2016/8/15 18:19
 */
@Service
public class StudentServiceImpl implements StudentService {

   @Autowired
   private StudentDao studentDao;

    @Override
    public StudentDao getStudentDao() {
        return studentDao;
    }
}
