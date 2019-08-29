package com.tiger.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public abstract interface MapperUtils<T>
  extends Mapper<T>, MySqlMapper<T>
{}


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\MapperUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */