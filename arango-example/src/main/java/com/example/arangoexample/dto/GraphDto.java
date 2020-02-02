package com.example.arangoexample.dto;

import lombok.Data;

import java.util.List;

@Data
public class GraphDto {
    List<NodeDto> nodes;
    List<RelationDto> relations;
}
