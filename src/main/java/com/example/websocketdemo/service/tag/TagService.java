package com.example.websocketdemo.service.tag;

import com.example.websocketdemo.domain.Tag;

import java.util.List;

public interface TagService {

    public Tag add(Tag tag);

    public List<Tag> findAll();
}
