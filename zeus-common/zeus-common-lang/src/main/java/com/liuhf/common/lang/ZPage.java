package com.liuhf.common.lang;

import java.util.List;

/**
 * @author liuhf
 * @date 2023/4/12
 * @since 1.0
 */
public class ZPage<T> {
    private final long total;
    private final List<T> data;

    public ZPage(long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public List<T> getData() {
        return data;
    }
}
