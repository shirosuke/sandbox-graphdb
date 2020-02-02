package com.example.arangoexample;

import com.example.arangoexample.dto.GraphRequest;
import com.example.arangoexample.dto.GraphView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * グラフAPI
 */
@RestController
@RequestMapping("/api")
public class GraphApi {

    @PostMapping("/graph")
    public ResponseEntity<String> create(@RequestBody GraphRequest request) {
        return ResponseEntity.ok("hoge");
    }

    @GetMapping("/graph")
    public ResponseEntity<GraphView> graphs() {
        return ResponseEntity.ok(new GraphView());
    }
}
