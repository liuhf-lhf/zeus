package com.liuhf.common.lang;

/**
 * @author liuhf
 * @date 2023/4/23
 * @since 1.0
 */
public class ZRequestPage {
    protected int page = 1;
    protected int pageSize = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "ZRequestPage{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
