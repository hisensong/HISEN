package com.dmall.hisen.controller;

import com.dmall.hisen.domain.User;
import com.dmall.hisen.domain.entity.StudentEntity;
import com.dmall.hisen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description:
 * Company:国美小额贷款有限公司
 * Author:HisenSong
 * DateTime: 2016/8/15 19:56
 */
@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(value="/query", method= RequestMethod.GET)
    public List<StudentEntity> queryStudent(){
       List<StudentEntity> studentEntityList = studentService.getStudentDao().findList(null);
        return studentEntityList;
    }

}
