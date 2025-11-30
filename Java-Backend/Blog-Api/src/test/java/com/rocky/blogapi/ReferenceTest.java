package com.rocky.blogapi;


import com.rocky.blogapi.entity.User;
import com.rocky.blogapi.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReferenceTest {

    @Autowired
    private IUserService userService;

    @Test
    void testGetOne(){
        User user = userService.getById(1L);

        if(user != null){
            System.out.println("成功抓取用戶: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
        }else{
            System.out.println("找不到用戶，請檢查資料庫是否有 ID=1 的資料");
        }
    }

}
