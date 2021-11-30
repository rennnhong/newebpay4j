//package idv.rennnhong.neweb.http;
//
//import okhttp3.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSession;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import java.io.IOException;
//import java.security.cert.CertificateException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Http調用工具類 todo 之後要抽象
// */
//public class HttpInvoker {
//
//    Logger logger = LoggerFactory.getLogger(HttpInvoker.class);
//
//    private OkHttpClient client;
//
//    public HttpInvoker() {
//        client = buildTrustAllOkHttpClient();
//    }
//
//    public HttpResult post(String url, Map<String, String> body) {
//        FormBody.Builder formBodyBuilder = new FormBody.Builder();
//        body.forEach(formBodyBuilder::add);
//        return send(new Request.Builder()
//                .url(url)
//                .post(formBodyBuilder.build())
//                .build());
//    }
//
//    public HttpResult post(String url, String body) {
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), body);
//        Request request = new Request.Builder()
//                .url(url)
//                .post(requestBody)
//                .build();
//
////        logger.info(request.toString());
////        logger.info(body);
//
//        return send(new Request.Builder()
//                .url(url)
//                .post(requestBody)
//                .build());
//    }
//
//    private HttpResult send(Request request) {
//        try (Response response = client.newCall(request).execute()) {
//            Map<String, String> headers = new HashMap<>();
//
//            response.headers().forEach(header -> {
//                headers.put(header.getFirst(),header.getSecond());
////                System.out.println(MessageFormat.format("{0}\t{1}",header.getFirst(),header.getSecond()));
//            });
//            HttpResult httpResult = new HttpResult();
//            httpResult.setCode(response.code());
//            httpResult.setHeaders(headers);
//            httpResult.setBody(response.body().string());
//            return httpResult;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 使 OK HTTP client 忽略 TLS 信任錯誤
//     */
//    private OkHttpClient buildTrustAllOkHttpClient() {
//        final TrustManager[] trustAllCerts = new TrustManager[]{
//                new X509TrustManager() {
//                    @Override
//                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
//                    }
//
//                    @Override
//                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
//                    }
//
//                    @Override
//                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                        return new java.security.cert.X509Certificate[0];
//                    }
//                }
//        };
//
//        SSLContext sslContext;
//        try {
//            sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, trustAllCerts, null);
//        } catch (Exception e) {
//            throw new RuntimeException("OKHttp is not OK!");
//        }
//
//        return new OkHttpClient.Builder()
//                .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0])
//                .hostnameVerifier((String s, SSLSession sslSession) -> true)
//                .build();
//    }
//
//}
//
