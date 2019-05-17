package com.xiekong.shardingjdbc.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author XieKong
 * @date 2019/5/17 11:08
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String nickName;
}
