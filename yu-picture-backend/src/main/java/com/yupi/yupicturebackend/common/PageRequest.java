package com.yupi.yupicturebackend.common;

import com.yupi.yupicturebackend.exception.ErrorCode;
import com.yupi.yupicturebackend.exception.ThrowUtils;
import lombok.Data;

/**
 * 通用的分页请求类
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private int current = 1;

    /**
     * 页面大小
     */
    private int pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认升序）
     */
    private String sortOrder = "descend";

    public void setSortField(String sortField) {
        if (sortField != null && !sortField.isEmpty()) {
            ThrowUtils.throwIf(!sortField.matches("^[a-zA-Z][a-zA-Z0-9]*$"),
                    ErrorCode.PARAMS_ERROR, "排序字段名称不合法");
        }
        this.sortField = sortField;
    }
}