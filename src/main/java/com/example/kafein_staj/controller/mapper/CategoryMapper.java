package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.CategoryDTO;
import com.example.kafein_staj.datatransferobject.OrderDTO;
import com.example.kafein_staj.entity.Category;
import com.example.kafein_staj.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CategoryMapper {
    @Mappings({
            @Mapping(target = "category_parent_id", source = "categoryParentId"),
            @Mapping(target = "category_id", source = "categoryId"),

    })
    CategoryDTO makeDTOFromCategory(Category category); // from Entity to DTO

    @Mappings({
            @Mapping(target = "categoryParentId", source = "category_parent_id"),
            @Mapping(target = "categoryId", source = "category_id"),

    })
    Category makeCategoryFromDTO(CategoryDTO categoryDTO); // from DTO to Entity

}
