package com.example.arangoexample.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
public class NodeDto {
    @ApiModelProperty(position = 1)
    String id;
    @ApiModelProperty(position = 2)
    String name;
    @ApiModelProperty(position = 3)
    String label;
    @ApiModelProperty(position = 4)
    Map<String, Object> properties;
}
