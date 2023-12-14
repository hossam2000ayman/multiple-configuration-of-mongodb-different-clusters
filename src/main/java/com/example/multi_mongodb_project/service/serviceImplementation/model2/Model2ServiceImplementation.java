package com.example.multi_mongodb_project.service.serviceImplementation.model2;

import com.example.multi_mongodb_project.model2.Model2;
import com.example.multi_mongodb_project.model2.Model2Repository;
import com.example.multi_mongodb_project.service.Model2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Model2ServiceImplementation implements Model2Service {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Model2Repository model2Repository;



    @Override
    public Model2 addModel2(Model2 model2) {
        return model2Repository.save(model2);
    }

    @Override
    public void initializeModel2(List<Model2> model2s) {
        model2Repository.saveAll(model2s);
    }

    @Override
    public void deleteModel2(String id) {
        Optional<Model2> model2Optional = model2Repository.findById(id);

        if(model2Optional.isEmpty())
            throw new RuntimeException("Model2 not found");
        model2Repository.deleteById(id);
    }

    @Override
    public void destroyModel2s() {
        model2Repository.deleteAll();
    }

    @Override
    public Model2 updateModel2(String id, Model2 newModel2) {
        Optional<Model2> model2Optional = model2Repository.findById(id);

        if(model2Optional.isEmpty())
            throw new RuntimeException("Model2 not found");
        Model2 model2 = model2Optional.get();
        model2.setAge(newModel2.getAge());
        model2.setName(newModel2.getName());
        model2.setSalary(newModel2.getSalary());
        return model2Repository.save(model2);
    }

    @Override
    public Model2 getModel2(String id) {
        Optional<Model2> model2Optional = model2Repository.findById(id);

        if(model2Optional.isEmpty())
            throw new RuntimeException("Model2 not found");
        return model2Optional.get();
    }

    @Override
    public List<Model2> getAllModel2s() {
        return model2Repository.findAll();
    }
}
