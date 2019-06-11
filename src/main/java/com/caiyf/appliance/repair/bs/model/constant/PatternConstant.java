package com.caiyf.appliance.repair.bs.model.constant;

import java.util.regex.Pattern;

/**
 * @desc 正则表达式常量
 * @date 2019/04/17
 * @author caiyf
 */
public class PatternConstant {

    public static final String DATE_CONSTANT = "yyyy-MM-dd HH:mm:ss";
    public static final Pattern DATE_PATTERN = Pattern.compile(DATE_CONSTANT);

}
