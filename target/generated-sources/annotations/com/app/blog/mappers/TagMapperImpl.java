package com.app.blog.mappers;

import com.app.blog.domain.dtos.TagDto;
import com.app.blog.domain.entities.Tag;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-03T16:34:24+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagDto toTagResponse(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDto.TagDtoBuilder tagDto = TagDto.builder();

        tagDto.postCount( calculatePostCount( tag.getPosts() ) );
        tagDto.id( tag.getId() );
        tagDto.name( tag.getName() );

        return tagDto.build();
    }
}
