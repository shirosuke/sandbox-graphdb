package com.example.arangoexample.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
public class RelationDto {
    @ApiModelProperty(position = 1)
    String type;
    @ApiModelProperty(position = 2)
    String startNodeId;
    @ApiModelProperty(position = 3)
    String endNodeId;
    @ApiModelProperty(position = 4)
    Map<String, Object> properties;
}
