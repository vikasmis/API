package com.example.userapi.Mapper;

import com.example.userapi.dto.MusicItemsRequest;
import com.example.userapi.entity.MusicItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MusicMapper {
    MusicItems toEntity(MusicItemsRequest request);
}
