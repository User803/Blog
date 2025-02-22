package com.app.blog.mappers;

import com.app.blog.domain.CreatePostRequest;
import com.app.blog.domain.UpdatePostRequest;
import com.app.blog.domain.dtos.CreatePostRequestDto;
import com.app.blog.domain.dtos.PostDto;
import com.app.blog.domain.dtos.UpdatePostRequestDto;
import com.app.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "status", source = "status")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    UpdatePostRequest toUpdatePostRequestDto(UpdatePostRequestDto dto);
}
