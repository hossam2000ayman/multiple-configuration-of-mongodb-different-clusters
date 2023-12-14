package com.example.multi_mongodb_project.service;

import com.example.multi_mongodb_project.model2.Model2;

import java.util.List;

public interface Model2Service {
    Model2 addModel2(Model2 model2);

    void initializeModel2(List<Model2> model2s);

    void deleteModel2(String id);
    void destroyModel2s();

    Model2 updateModel2(String id, Model2 newModel2);

    Model2 getModel2(String id);

    List<Model2> getAllModel2s();



}
