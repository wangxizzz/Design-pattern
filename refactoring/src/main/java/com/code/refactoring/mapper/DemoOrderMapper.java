package com.code.refactoring.mapper;

import com.code.refactoring.spring相关.事务相关.domain.DemoOrderDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DemoOrderMapper
 * @author: wangxi03
 * @date: 2020/08/02 10:44:23 
 */
@Mapper
@Repository
public interface DemoOrderMapper {
    String ALL_FIELD = "id , price , order_no , book_id , order_name , order_user_name , create_time , update_time";

    /**
     * 根据ID查询
     * @param id id
     */
    @Results(
            id = "resultMap",
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "price", property = "price"),
                    @Result(column = "order_no", property = "orderNo"),
                    @Result(column = "book_id", property = "bookId"),
                    @Result(column = "order_name", property = "orderName"),
                    @Result(column = "order_user_name", property = "orderUserName"),
                    @Result(column = "create_time", property = "createTime"),
                    @Result(column = "update_time", property = "updateTime")
            }
    )
    @Select({
            "SELECT " ,
             ALL_FIELD ,
            " FROM ",
            "demo_order",
            " WHERE id = #{id} "
    })
    DemoOrderDO getById(@Param("id") Long id);

    /**
     * 根据条件查询
     */
    @ResultMap("resultMap")
    @Select({
            "<script>",
            "SELECT " ,
             ALL_FIELD ,
            " FROM ",
            "demo_order",
            "<where>",
            "    <if test=\"id != null\">",
            "        AND id = #{id}",
            "    </if>",
            "    <if test=\"price != null\">",
            "        AND price = #{price}",
            "    </if>",
            "    <if test=\"orderNo != null\">",
            "        AND order_no = #{orderNo}",
            "    </if>",
            "    <if test=\"bookId != null\">",
            "        AND book_id = #{bookId}",
            "    </if>",
            "    <if test=\"orderName != null\">",
            "        AND order_name = #{orderName}",
            "    </if>",
            "    <if test=\"orderUserName != null\">",
            "        AND order_user_name = #{orderUserName}",
            "    </if>",
            "    <if test=\"createTime != null\">",
            "        AND create_time = #{createTime}",
            "    </if>",
            "    <if test=\"updateTime != null\">",
            "        AND update_time = #{updateTime}",
            "    </if>",
            "</where>",
            "</script>"
    })
    List<DemoOrderDO> list(DemoOrderDO DemoOrderDO);

    /**
     * 新增
     */
    @Insert({
            "INSERT INTO ",
            "demo_order",
            " (",
            "id , price , order_no , book_id , order_name , order_user_name , create_time , update_time",
            " ) VALUES ( ",
            "#{id} , #{price} , #{orderNo} , #{bookId} , #{orderName} , #{orderUserName} , #{createTime} , #{updateTime}",
            ")"
    })
    int insert(DemoOrderDO DemoOrderDO);

    /**
     * 更新
     */
    @Update({
            "<script>",
            "UPDATE ",
            "demo_order" ,
            " <set> ",
            "        <if test=\"price != null\">`price`=#{price},</if>",
            "        <if test=\"orderNo != null\">`order_no`=#{orderNo},</if>",
            "        <if test=\"bookId != null\">`book_id`=#{bookId},</if>",
            "        <if test=\"orderName != null\">`order_name`=#{orderName},</if>",
            "        <if test=\"orderUserName != null\">`order_user_name`=#{orderUserName},</if>",
            "        <if test=\"createTime != null\">`create_time`=#{createTime},</if>",
            "        <if test=\"updateTime != null\">`update_time`=#{updateTime},</if>",
            " </set> ",
            " <where> ",
            "     AND `id` = #{id} ",
            "</where>",
            "</script>"
    })
    int update(DemoOrderDO DemoOrderDO);
}
