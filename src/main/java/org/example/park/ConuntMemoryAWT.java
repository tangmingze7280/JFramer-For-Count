package org.example.park;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import org.example.entity.CountMemory;


/**
 * @program: JFramer-demo
 * @description:
 * @author: tmz
 * @create: 2021-02-02 16:04
 */
public class ConuntMemoryAWT {
    public Long increatment() throws Exception{
        CountMemory by = current();
        if(by==null){
            by = create();
        }
        by.increament();
        Db.use().execute("update count_memory set count_num = ? where id = ?", by.getCountNum(), by.getId());
        return by.getCountNum();
    }
    public CountMemory create()throws Exception{
        String today = DateUtil.today();
        CountMemory by = current();
        if(by!=null){
            return by;
        }
        Db.use().execute("insert into count_memory values (?, ?, DATE(?))", null, 1, today);
        by = current();
        return by;
    }
    public void clear() throws Exception{
        CountMemory current = current();
        Db.use().execute("update count_memory set count_num = ? where id = ?", 0, current.getId());
    }
    public CountMemory current() throws Exception{
        String today = DateUtil.today();
        Entity entity = Db.use().queryOne("SELECT * FROM `count_memory` where `current_date` = DATE(?)", today);
        if(entity!=null){
            return entity.toBean(CountMemory.class);
        }
        return  null;
    }
}
