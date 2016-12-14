package com.yiqiang.crawler.httpclient;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/11 0011 0:19
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class HttpConnectManager {

    public static void main(String[] args) {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // 设置最大连接数
        cm.setMaxTotal(200);
        // 设置没个主机地址的并发数
        cm.setDefaultMaxPerRoute(20);

        doGet(cm);
        doGet(cm);
    }

    public static void doGet(HttpClientConnectionManager hccm) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(hccm).build();

        // 创建http GET请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        CloseableHttpResponse response = null;

        try {
            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("content length: " + content.length());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//          此处不能关闭httpClient，如果关闭httpClient，连接池也会销毁
//			httpClient.close();
        }
    }
}
