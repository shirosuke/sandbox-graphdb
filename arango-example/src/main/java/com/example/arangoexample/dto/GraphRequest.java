package com.example.arangoexample.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GraphRequest {
    @ApiModelProperty(position = 1)
    String name;
    @ApiModelProperty(position = 2)
    GraphDto graph;
}
