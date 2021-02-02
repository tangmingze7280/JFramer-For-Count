package org.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: JFramer-demo
 * @description:
 * @author: tmz
 * @create: 2021-02-02 15:57
 */
@Data
public class CountMemory implements Serializable {
    private Integer id;

    private Long countNum;

    private Date currentDate;

    public void increament(){
        this.countNum = this.countNum+1;
    }
}
