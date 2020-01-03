package com.netmarch.web.common.mybatis;

import tk.mybatis.mapper.common.*;

public interface MyBaseMapper <T> extends Mapper<T>, MySqlMapper<T> {
}
