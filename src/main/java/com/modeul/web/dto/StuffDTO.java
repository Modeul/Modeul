package com.modeul.web.dto;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.Image;
import com.modeul.web.entity.Stuff;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StuffDTO {
    private Image image;
    private Stuff stuff;
    private Category category;
}
