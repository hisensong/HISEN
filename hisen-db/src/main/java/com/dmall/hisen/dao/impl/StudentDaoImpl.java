package com.dmall.hisen.dao.impl;
import com.dmall.common.dao.AbstractBaseDao;
import com.dmall.common.dao.TableDes;
import com.dmall.hisen.dao.StudentDao;
import com.dmall.hisen.domain.entity.StudentEntity;
import org.springframework.stereotype.Repository;

@TableDes(nameSpace = "studentMapper", tableName = "Student")
@Repository
public class StudentDaoImpl extends AbstractBaseDao<StudentEntity, Long> implements StudentDao {
	
}