package com.caiyf.appliance.repair.bs.model.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @desc 分页数据
 * @date 2019/04/13
 * @author caiyf
 */
@Data
public class PageModel<T> {

    private Long totalCount;
    private Integer pageNum;
    private Integer pageSize;
    private List<T> dataInfo;

    PageModel(PageInfo pageInfo) {
        this.totalCount = pageInfo.getTotal();
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.dataInfo = pageInfo.getList();
    }

}
