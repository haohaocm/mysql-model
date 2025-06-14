package org.example.mysqlmodel.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.mysqlmodel.Entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
