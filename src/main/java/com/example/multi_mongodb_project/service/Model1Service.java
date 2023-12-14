package com.example.multi_mongodb_project.service;

import com.example.multi_mongodb_project.model1.Model1;

import java.util.List;

public interface Model1Service {
    Model1 addModel1(Model1 Model1);

    void initializeModel1(List<Model1> model2s);

    void deleteModel1(String id);
    void destroyModel1s();

    Model1 updateModel1(String id, Model1 newModel2);

    Model1 getModel1(String id);

    List<Model1> getAllModel1s();

}
