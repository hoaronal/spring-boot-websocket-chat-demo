package com.example.websocketdemo.repository;

import com.example.websocketdemo.domain.Post;
import com.example.websocketdemo.model.PostSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {

    void lock(long id);

    Page<Post> search(PostSearchRequest request, Pageable pageable);
}
