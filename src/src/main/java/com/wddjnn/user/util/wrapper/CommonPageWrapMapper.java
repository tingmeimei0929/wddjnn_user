package com.wddjnn.user.util.wrapper;

public class CommonPageWrapMapper {

    private CommonPageWrapMapper() {
    }

    public static <E> CommonPageWrapper<E> wrap(int code, String message, E result, Integer totalRow) {
        return new CommonPageWrapper(code, message, result, totalRow);
    }

    public static <E> CommonPageWrapper<E> wrap(E result, Integer totalRow) {
        return wrap(200, "OK", result, totalRow);
    }

    public static <E> CommonPageWrapper<E> wrap(int code, String message) {
        return wrap(code, message, null, (Integer) null);
    }

    public static <E> CommonPageWrapper<E> wrap(int code) {
        return wrap(code, (String) null, null, (Integer) null);
    }

    public static <E> CommonPageWrapper<E> wrap(Exception e) {
        return new CommonPageWrapper(500, e.getMessage(), (Object) null, (Integer) null);
    }

    public static <E> E unWrap(CommonPageWrapper<E> wrapper) {
        return wrapper.getResult();
    }

    public static <E> CommonPageWrapper<E> illegalArgument() {
        return wrap(100, "参数非法", null, null);
    }

    public static <E> CommonPageWrapper<E> timeOut() {
        return wrap(110, "安全认证失败，时间过期");
    }

    public static <E> CommonPageWrapper<E> secureFail() {
        return wrap(120, "安全认证失败，签名错误");
    }

    public static <E> CommonPageWrapper<E> error() {
        return wrap(500, "抱歉，当前值班小哥翘班了，我们马上报告老板！", null, null);
    }

    public static <E> CommonPageWrapper<E> ok() {
        return new CommonPageWrapper();
    }
}
