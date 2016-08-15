//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.dao;

import com.dmall.common.domain.Criteria;
import com.dmall.common.domain.Page;
import com.dmall.common.domain.PageBean;
import java.util.List;

public interface BaseDao<M extends Criteria, PK> {
    String SQL_SELECT = "select";
    String SQL_UPDATE = "update";
    String SQL_DELETE = "delete";
    String SQL_INSERT = "insert";
    String SQL_COUNT = "count";
    String SQL_BATCH = "Batch";
    String SQL_ONE = "One";
    int DEFAULT_PAGE_SIZE = 10;
    String IBATIS_PROPERYTY_PREFIX = "_";

    int save(M var1);

    int saveAll(List<M> var1);

    int update(M var1, M var2);

    int update(M var1);

    int updateAll(List<M> var1);

    int saveOrUpdate(M var1);

    int saveOrUpdate(List<M> var1);

    int delete(PK var1);

    int delete(M var1);

    M get(PK var1);

    int count(M var1);

    List<M> findList(M var1);

    List<M> findList(M var1, int var2, int var3);

    PageBean<M> pageQuery(M var1, PageBean<M> var2);

    Page<M> pageQuery(M var1, Integer var2, Integer var3);

    M findOne(M var1);

    boolean exists(PK var1);
}
