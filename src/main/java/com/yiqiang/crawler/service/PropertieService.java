package com.yiqiang.crawler.service;

import com.yiqiang.crawler.spring.PropertyConfig;
import org.springframework.stereotype.Service;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/11 0011 15:32
 *
 * @author: YEEQiang
 * @version: 1.0
 */

@Service
public class PropertieService {

    @PropertyConfig
    public String IMAGE_DIR;

    @PropertyConfig
    public String MAX_POOL_SIZE;
}
