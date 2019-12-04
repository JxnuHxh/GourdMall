package com.hlz.gourdmall.util;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Davion
 * @date: 2019/12/4
 * @description: 分页数据详情
 */
@Component
public class Page2Data {
    public Map<String, Object> page2Data(Page page) {
        Map<String, Object> data = new HashMap<>();
        data.put("pageNum", page.getPageNum());
        data.put("pageSize", page.getPageSize());
        data.put("startRow", page.getStartRow());
        data.put("endRow", page.getEndRow());
        data.put("total", page.getTotal());
        data.put("pages", page.getPages());
        data.put("data", page);
        return data;
    }
}
