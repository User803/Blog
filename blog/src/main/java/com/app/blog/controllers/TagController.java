package com.app.blog.controllers;

import com.app.blog.domain.dtos.CreateTagsRequest;
import com.app.blog.domain.dtos.TagResponse;
import com.app.blog.domain.entities.Tag;
import com.app.blog.mappers.TagMapper;
import com.app.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
        List<Tag> tags = tagService.getTags();
        List<TagResponse> tagResponses = tags.stream()
                .map(tagMapper::toTagResponse).toList();

        return ResponseEntity.ok(tagResponses);
    }

    @PostMapping
    public ResponseEntity<List<TagResponse>> createTags(
            @RequestBody CreateTagsRequest createTagsRequest) {

        List<Tag> savedTags = tagService.createTags(createTagsRequest.getNames());
        List<TagResponse> createdTagResponses = savedTags.stream()
                .map(tagMapper::toTagResponse)
                .toList();

        return new ResponseEntity<>(createdTagResponses, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id) {
        tagService.deleteTag(id);

        return ResponseEntity.noContent().build();
    }
}
