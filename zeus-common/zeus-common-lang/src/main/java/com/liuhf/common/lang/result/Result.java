package com.liuhf.common.lang.result;


import cn.hutool.core.bean.BeanUtil;
import com.liuhf.common.lang.ZPage;
import com.liuhf.common.lang.enums.Status;

import java.util.Collection;
import java.util.List;


public class Result<T> {
    private String status;
    private T data;
    private String message;

    private boolean success;

    public Result(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        success = status.equals("200");
    }

    public Result(Status status, T data) {
        this(status.getCode(), data, status.getMessage());
    }

    public static <T> Result<T> success(T data) {
        return success(data, Status.SUCCESS);
    }

    public static <T> Result<List<T>> success(List<T> data) {
        return success(data, Status.SUCCESS);
    }
    public static <T,U> Result<List<U>> success(List<T> data,Class<U> cast) {
        return success(data.stream().map(d->BeanUtil.copyProperties(d,cast)).toList(), Status.SUCCESS);
    }
    public static <T> Result<Collection<T>> success(Collection<T> data) {
        return success(data, Status.SUCCESS);
    }

    public static <T, U> Result<U> success(T data, Class<U> cast) {
        return success(BeanUtil.copyProperties(data, cast), Status.SUCCESS);
    }

    public static <T> Result<ZPage<T>> success(List<T> data, long total) {
        return new Result<>(Status.SUCCESS, new ZPage<>(total, data));
    }

    public static <T, U> Result<ZPage<U>> success(List<T> data, long total, Class<U> cast) {
        return new Result<>(Status.SUCCESS, new ZPage<>(total, data.stream().map(u -> BeanUtil.copyProperties(u, cast)).toList()));
    }

    public static <T> Result<T> success(T data, Status status) {
        return new Result<>(status, data);
    }

    public static <T> Result<T> failed(Status status) {
        return new Result<>(status, null);
    }

    public static <T> Result<T> failed() {
        return failed(Status.FAILED);
    }

    public static <T> Result<T> failed(Status status, String message) {
        return new Result<>(status.getCode(), null, message);
    }
    public static <T> Result<T> failed(String code, String message) {
        return new Result<>(code, null, message);
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
