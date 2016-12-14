package com.yiqiang.crawler.util;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/11 0011 15:05
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class IdleConnectionEvictor extends Thread{

    private final HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    private Integer waitTime;

    public IdleConnectionEvictor(HttpClientConnectionManager connMgr, Integer waitTime) {
        super();
        this.connMgr = connMgr;
        this.waitTime = waitTime;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                wait(waitTime);
                // 关闭无效的连接
                connMgr.closeExpiredConnections();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
