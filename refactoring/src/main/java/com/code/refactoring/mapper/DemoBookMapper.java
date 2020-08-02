package com.code.refactoring.mapper;

import com.code.refactoring.spring相关.事务相关.domain.DemoBookDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DemoBookMapper
 * @author: wangxi03
 * @date: 2020/08/02 10:44:23 
 */
@Mapper
@Repository
public interface DemoBookMapper {
    String ALL_FIELD = "id , book_name , book_desc , publish_time , sell_count , create_time , update_time";

    /**
     * 根据ID查询
     * @param id id
     */
    @Results(
            id = "resultMap",
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "book_name", property = "bookName"),
                    @Result(column = "book_desc", property = "bookDesc"),
                    @Result(column = "publish_time", property = "publishTime"),
                    @Result(column = "sell_count", property = "sellCount"),
                    @Result(column = "create_time", property = "createTime"),
                    @Result(column = "update_time", property = "updateTime")
            }
    )
    @Select({
            "SELECT " ,
             ALL_FIELD ,
            " FROM ",
            "demo_book",
            " WHERE id = #{id} "
    })
    DemoBookDO getById(@Param("id") Long id);

    /**
     * 根据条件查询
     */
    @ResultMap("resultMap")
    @Select({
            "<script>",
            "SELECT " ,
             ALL_FIELD ,
            " FROM ",
            "demo_book",
            "<where>",
            "    <if test=\"id != null\">",
            "        AND id = #{id}",
            "    </if>",
            "    <if test=\"bookName != null\">",
            "        AND book_name = #{bookName}",
            "    </if>",
            "    <if test=\"bookDesc != null\">",
            "        AND book_desc = #{bookDesc}",
            "    </if>",
            "    <if test=\"publishTime != null\">",
            "        AND publish_time = #{publishTime}",
            "    </if>",
            "    <if test=\"sellCount != null\">",
            "        AND sell_count = #{sellCount}",
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
    List<DemoBookDO> list(DemoBookDO DemoBookDO);

    /**
     * 新增
     */
    @Insert({
            "INSERT INTO ",
            "demo_book",
            " (",
            "id , book_name , book_desc , publish_time , sell_count , create_time , update_time",
            " ) VALUES ( ",
            "#{id} , #{bookName} , #{bookDesc} , #{publishTime} , #{sellCount} , #{createTime} , #{updateTime}",
            ")"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(DemoBookDO DemoBookDO);

    /**
     * 更新
     */
    @Update({
            "<script>",
            "UPDATE ",
            "demo_book" ,
            " <set> ",
            "        <if test=\"bookName != null\">`book_name`=#{bookName},</if>",
            "        <if test=\"bookDesc != null\">`book_desc`=#{bookDesc},</if>",
            "        <if test=\"publishTime != null\">`publish_time`=#{publishTime},</if>",
            "        <if test=\"sellCount != null\">`sell_count`=#{sellCount},</if>",
            "        <if test=\"createTime != null\">`create_time`=#{createTime},</if>",
            "        <if test=\"updateTime != null\">`update_time`=#{updateTime},</if>",
            " </set> ",
            " <where> ",
            "     AND `id` = #{id} ",
            "</where>",
            "</script>"
    })
    int update(DemoBookDO DemoBookDO);
}
