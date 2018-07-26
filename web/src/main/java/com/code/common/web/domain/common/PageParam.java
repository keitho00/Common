package com.code.common.web.domain.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 说明：分页搜索参数
 * Date:17-5-28
 * Time:下午2:11
 */
@Data
@NoArgsConstructor
public class PageParam {
    private static final int MAX_PAGE_SIZE = 7000;

    //第多少页
    protected int pageNum = 1;
    //每页多少条
    protected int pageSize = 20;
    //数据库分页参数
    private String page;

    public PageParam(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getOffSet() {
        return (pageNum - 1) * getLimit();
    }

    public String getPage() {
        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        //分页计算
        int pageStartNum = (pageNum - 1) * pageSize;
        return " limit " + String.valueOf(pageStartNum) + "," + String.valueOf(pageSize);
    }

    public int getLimit() {
        return pageSize > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize;
    }

}
