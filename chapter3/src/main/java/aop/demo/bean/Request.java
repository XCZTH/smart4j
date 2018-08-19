package aop.demo.bean;

public class Request {

    private String requestMethod;

    private String requestPath;

    public Request(String requestMethod,String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath=requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
