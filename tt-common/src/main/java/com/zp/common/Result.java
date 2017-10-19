package com.zp.common;

import java.util.List;

/**
 * User: zhangpeng
 * Date: 2017/10/18
 * Time: 19:11
 * Version:V1.0
 */
public class Result<T> {
    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
