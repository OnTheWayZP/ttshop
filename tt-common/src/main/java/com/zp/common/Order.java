package com.zp.common;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhangpeng
 * Date: 2017/10/20
 * Time: 21:40
 * Version:V1.0
 */
public class Order {
    String order;
    String sort;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
    public List<String> getOrderParams() {
        String[] sorts = this.sort.split(",");//id,title
        String[] orders = this.order.split(",");//asc,desc
        List<String> list = new ArrayList<String>();
        for (int i=0;i<sorts.length;i++){
            String temp = sorts[i] +" "+orders[i];//id asc;title desc
            list.add(temp);//[id asc;title desc]
        }
        return list;
    }
}
