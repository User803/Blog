package com.app.blog.services;

import com.app.blog.domain.CreatePostRequest;
import com.app.blog.domain.UpdatePostRequest;
import com.app.blog.domain.entities.Post;
import com.app.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
}
