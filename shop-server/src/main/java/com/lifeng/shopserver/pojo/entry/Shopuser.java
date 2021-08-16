package com.lifeng.shopserver.pojo.entry;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jsonlinlin7
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Shopuser implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "userid", type = IdType.AUTO)

      private Integer userid;

    private String username;

    private String password;

    private String phone;

    private String address;

  /**
   * 创建时间
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createtime;

  /**
   * 更新时间
   */
  @TableField(fill = FieldFill. INSERT_UPDATE)
  private Date updatetime;


}
