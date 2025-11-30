package com.rocky.blogapi.controller;

import com.rocky.blogapi.entity.User;
import com.rocky.blogapi.ommon.lang.Result;
import com.rocky.blogapi.service.IUserService;
import com.rocky.blogapi.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Rocky
 * @since 2025-11-29
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    com.rocky.blogapi.util.JwtUtils jwtUtils;

    @GetMapping("/{id}")
    public Result index(@PathVariable("id") Long id) {
        // 根據 ID 查詢用戶
        User user = userService.getById(id);

        // 如果找不到，拋出異常（會被 GlobalExceptionHandler 捕捉）
        if (user == null) {
            throw new RuntimeException("用戶不存在，ID: " + id);
        }

        // 如果找到了，回傳統一格式
        return Result.succ(user);
    }

    @GetMapping("/test-jwt")
    public Result testJwt(){
        String token = jwtUtils.generateToken(1L);
        return Result.succ(token);
    }
}
