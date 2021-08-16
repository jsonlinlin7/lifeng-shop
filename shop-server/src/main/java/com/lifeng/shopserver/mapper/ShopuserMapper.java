package com.lifeng.shopserver.mapper;

import com.lifeng.shopserver.pojo.entry.Shopuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author jsonlinlin7
 */
@Repository
public interface ShopuserMapper extends BaseMapper<Shopuser> {
    @Select("select userid from shopuser where username = #{username}")
    String selectByUsername(String username);

    @Select("select password from shopuser where username = #{username}")
    String selectPdByUsername(String username);

}
