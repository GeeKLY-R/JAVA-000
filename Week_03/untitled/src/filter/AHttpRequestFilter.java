package filter;

public class AHttpRequestFilter implements HttpRequestFilter {

    final static String NIO_KEY = "nio";
    final static String NIO_VALUE = "zhouhao";

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        // 往请求头中添加一个新的key-value
        fullRequest.headers().add(NIO_KEY, NIO_VALUE);
    }
}