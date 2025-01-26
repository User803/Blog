package com.app.blog.mappers;

import com.app.blog.domain.dtos.TagResponse;
import com.app.blog.domain.entities.Tag;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-26T12:37:52+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagResponse toTagResponse(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagResponse.TagResponseBuilder tagResponse = TagResponse.builder();

        tagResponse.postCount( calculatePostCount( tag.getPosts() ) );
        tagResponse.id( tag.getId() );
        tagResponse.name( tag.getName() );

        return tagResponse.build();
    }
}
