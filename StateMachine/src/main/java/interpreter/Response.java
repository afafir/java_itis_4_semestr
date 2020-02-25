package interpreter;

public class Response<T> {
    String header;
    T data;

    public String getHeader() {
        return header;
    }

    public T getData() {
        return data;
    }

    public Response(String header, T data) {
        this.header = header;
        this.data = data;
    }
}
