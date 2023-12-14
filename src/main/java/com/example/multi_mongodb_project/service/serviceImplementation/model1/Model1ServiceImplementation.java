package com.example.multi_mongodb_project.service.serviceImplementation.model1;

import com.example.multi_mongodb_project.model1.Model1;
import com.example.multi_mongodb_project.model1.Model1Repository;
import com.example.multi_mongodb_project.service.Model1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Model1ServiceImplementation implements Model1Service {

    private MongoTemplate mongoTemplate;


    private Model1Repository model1Repository;

    @Autowired
    public Model1ServiceImplementation(MongoTemplate mongoTemplate, Model1Repository model1Repository) {
        this.mongoTemplate = mongoTemplate;
        this.model1Repository = model1Repository;
    }

    @Override
    public Model1 addModel1(Model1 model1) {
        return model1Repository.save(model1);
    }

    @Override
    public void initializeModel1(List<Model1> model1s) {
        model1Repository.saveAll(model1s);
    }

    @Override
    public void deleteModel1(String id) {
        Optional<Model1> model1Optional = model1Repository.findById(id) ;
        if(model1Optional.isEmpty())
            throw new RuntimeException("model 1 not found");
        model1Repository.deleteById(id);
    }

    @Override
    public void destroyModel1s() {
        model1Repository.deleteAll();

    }

    @Override
    public Model1 updateModel1(String id, Model1 newModel1) {
        Optional<Model1> model1Optional = model1Repository.findById(id) ;
        if(model1Optional.isEmpty())
            throw new RuntimeException("model 1 not found");
        Model1 model1 = model1Optional.get();
        model1.setAge(newModel1.getAge());
        model1.setName(newModel1.getName());
        model1.setSalary(newModel1.getSalary());
        return model1Repository.save(model1);
    }

    @Override
    public Model1 getModel1(String id) {
        Optional<Model1> model1Optional = model1Repository.findById(id) ;
        if(model1Optional.isEmpty())
            throw new RuntimeException("model 1 not found");
        return model1Optional.get();
    }

    @Override
    public List<Model1> getAllModel1s() {
        return model1Repository.findAll();
    }
}
