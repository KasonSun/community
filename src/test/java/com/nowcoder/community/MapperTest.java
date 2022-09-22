package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.LoginTicketMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(11);
        System.out.println(user);

        user = userMapper.selectByName("nowcoder11");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder11@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInserUser() {
        User user = new User();
        user.setUsername("唐三");
        user.setPassword("123456");
        user.setSalt("小舞");
        user.setEmail("tangsan@foxmail.com");
        user.setHeaderUrl("http://www.hub.com");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getUsername());
    }

    @Test
    public void updateUser() {
        int row = userMapper.updatePassword(150, "xiaowu");
        System.out.println(row);

        row = userMapper.updateHeader(150, "http://www.xiaowu.com");
        System.out.println(row);

        row = userMapper.updateStatus(150, 1);
        System.out.println(row);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost post:discussPosts){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("比比东");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectUpdateLoginTicket() {
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("比比东");
        System.out.println(loginTicket);
        loginTicketMapper.updateStatus("比比东", 1);
        loginTicket = loginTicketMapper.selectByTicket("比比东");
        System.out.println(loginTicket);
    }
}
