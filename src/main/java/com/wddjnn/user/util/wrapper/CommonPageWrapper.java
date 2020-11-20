package com.wddjnn.user.util.wrapper;

public class CommonPageWrapper <T> extends Wrapper<T> {
    private static final long serialVersionUID = 1L;
    private Integer totalRow = 0;

    public CommonPageWrapper() {
    }

    public CommonPageWrapper(int code, String message) {
        super(code, message);
    }

    public CommonPageWrapper(int code, String message, T result, Integer totalRow) {
        super(code, message, result);
        this.totalRow = totalRow;
    }

    public CommonPageWrapper(T result, Integer totalRow) {
        super.setResult(result);
        this.totalRow = totalRow;
    }

    public Integer getTotalRow() {
        return this.totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }
}
