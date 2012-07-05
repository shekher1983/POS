package com.chandra.pos.model;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 7/1/12
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Pagination {


    int start;

    int pageSize;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
