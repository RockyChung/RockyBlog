package com.rocky.blogapi.service.impl;

import com.rocky.blogapi.entity.Blog;
import com.rocky.blogapi.mapper.BlogMapper;
import com.rocky.blogapi.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rocky
 * @since 2025-11-29
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
