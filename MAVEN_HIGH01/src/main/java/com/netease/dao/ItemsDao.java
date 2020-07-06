package com.netease.dao;

import com.netease.domain.Items;
import org.apache.ibatis.annotations.Select;

public interface ItemsDao {
    public Items findById(Integer id);
}
