package org.wc.tools.web.model;

/**
 * Created by WenChen on 2020/11/23.
 */
public class ResultMsg<T> {

    private String code;

    private String msg;

    private T data;

    private ResultMsg(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultMsg(ResultType type, T data) {
        this.code = type.getCode();
        this.msg = type.getMsg();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> ResultMsg<T> success(T t){
        return new ResultMsg<>(ResultType.SUCCESS,t);
    }

    public static <T> ResultMsg<T> fail(T t){
        return new ResultMsg<>(ResultType.FAILD,t);
    }

    public static <T> ResultMsg<T> timeout(T t){
        return new ResultMsg<>(ResultType.TIMEOUT,t);
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    private enum ResultType{
        SUCCESS("200","请求成功"),FAILD("500","请求失败"),TIMEOUT("300","请求超时");

        private String code;

        private String msg;

        ResultType(String code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
