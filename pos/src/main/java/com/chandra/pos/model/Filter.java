package com.chandra.pos.model;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/25/12
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Filter {


    protected String nameQuery;

    protected int pageSize = 10;

    protected int start = 0;

    public Filter() {

    }

    public Filter(int start, int pageSize) {
        this.start = start;
        this.pageSize = pageSize;
    }

    public String getNameQuery() {
        return nameQuery;
    }

    public void setNameQuery(String nameQuery) {
        this.nameQuery = nameQuery;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
