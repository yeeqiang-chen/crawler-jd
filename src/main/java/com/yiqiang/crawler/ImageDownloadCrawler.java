package com.yiqiang.crawler;

import com.yiqiang.crawler.service.HttpService;
import com.yiqiang.crawler.service.PropertieService;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Map;

/**
 * Title:
 * Description: 图片下载
 * Create Time: 2016/12/11 0011 16:09
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class ImageDownloadCrawler implements Crawler{

    /**
     * key：原始图片地址 value:新图片地址
     */
    private Map<String, String> urlMapping;

    public ImageDownloadCrawler(Map<String, String> urlMapping) {
        this.urlMapping = urlMapping;
    }

    @Override
    public void run() {
        if (this.urlMapping == null || this.urlMapping.isEmpty()) {
            return;
        }
        HttpService httpService = Main.applicationContext.getBean(HttpService.class);
        PropertieService propertieService = Main.applicationContext.getBean(PropertieService.class);
        for (Map.Entry<String, String> entry : this.urlMapping.entrySet()) {
            try {
                String url = entry.getKey();
                if (!StringUtils.startsWith(url, "http://")) {
                    url = "http:" + url;

                }
                httpService.downloadFile(url, new File(propertieService.IMAGE_DIR + entry.getValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
