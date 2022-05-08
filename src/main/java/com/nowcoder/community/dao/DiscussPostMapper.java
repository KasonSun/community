package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param注解用于给参数起别名
    //如果需要动态提供一个参数，并且这个方法只有一个参数，在<if>里使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
