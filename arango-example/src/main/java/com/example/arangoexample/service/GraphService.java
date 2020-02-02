package com.example.arangoexample.service;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoGraph;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.EdgeDefinition;
import com.arangodb.model.DocumentCreateOptions;
import com.arangodb.model.GraphCreateOptions;
import com.arangodb.springframework.core.ArangoOperations;
import com.example.arangoexample.dto.GraphDto;
import com.example.arangoexample.dto.GraphRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GraphService {
    @Autowired
    private ArangoOperations operations;
    @Autowired
    private ArangoDB db;

    public GraphDto create(GraphRequest request) {
        String dbName = "example-db";

        // TODO 動作確認後消す
        ArangoGraph graph = db.db(dbName).graph("sample-graph");
        // TODO 動的にEdgeDefinitionを取得する
        EdgeDefinition friend = new EdgeDefinition()
                .collection("友達")
                .from("人")
                .to("人");
//        EdgeDefinition likes = new EdgeDefinition()
//                .collection("好物")
//                .from("人")
//                .to("食べ物");
        graph.create(Arrays.asList(friend), new GraphCreateOptions());



        String collectionName1 = "人";
        try {
            db.db(dbName).createCollection(collectionName1);

            BaseDocument doc1 = new BaseDocument();
            doc1.addAttribute("id", request.getGraph().getNodes().get(0).getId());
            doc1.addAttribute("name", request.getGraph().getNodes().get(0).getName());
            doc1.addAttribute("label", request.getGraph().getNodes().get(0).getLabel());
            doc1.addAttribute("properties", request.getGraph().getNodes().get(0).getProperties());
            BaseDocument doc2 = new BaseDocument();
            doc2.addAttribute("id", request.getGraph().getNodes().get(1).getId());
            doc2.addAttribute("name", request.getGraph().getNodes().get(1).getName());
            doc2.addAttribute("label", request.getGraph().getNodes().get(1).getLabel());
            doc2.addAttribute("properties", request.getGraph().getNodes().get(1).getProperties());
            db.db(dbName).collection(collectionName1).insertDocuments(Arrays.asList(doc1, doc2), new DocumentCreateOptions());
            // TODO エッジのドキュメント追加
        } catch (ArangoDBException e) {
            System.err.println("Failed to create collection: " + collectionName1 + "; " + e.getMessage());
        }

        return null;
    }
}
