package com.example.multi_mongodb_project.controller.model1;

import com.example.multi_mongodb_project.model1.Model1;
import com.example.multi_mongodb_project.model2.Model2;
import com.example.multi_mongodb_project.service.Model1Service;
import com.example.multi_mongodb_project.service.Model2Service;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/model1")
@RequiredArgsConstructor
public class Model1Controller {

    private final Model1Service model1Service;
    private final Model2Service model2Service;


    @PostMapping("addModel1")
    Model1 addModel1(@RequestBody Model1 model1) {
        return model1Service.addModel1(model1);
    }

    @PostMapping("initializeModel1")
    void initializeModel1(@RequestBody List<Model1> model1s) {
        model1Service.initializeModel1(model1s);
    }

    @DeleteMapping("deleteModel1/{id}")
    void deleteModel1(@PathVariable String id) {
        model1Service.deleteModel1(id);
    }

    @DeleteMapping("destroyModel1s")
    void destroyModel1s() {

        model1Service.destroyModel1s();
    }

    @GetMapping("updateModel1/{id}")
    Model1 updateModel1(@PathVariable String id, @RequestBody Model1 newModel2) {
        return model1Service.updateModel1(id, newModel2);
    }

    @GetMapping("getModel1/{id}")
    Model1 getModel1(@PathVariable String id) {
        return model1Service.getModel1(id);
    }

    @GetMapping("getAllModel1s")
    List<Model1> getAllModel1s() {
        return model1Service.getAllModel1s();
    }


    @GetMapping("getAllModel1sAndModel2s")
    List getAllModel1sAndModel2s(){
        List<Model1> model1s = model1Service.getAllModel1s();
        List<Model2> model2s = model2Service.getAllModel2s();
        List models = new ArrayList();
        models.addAll(model1s);
        models.addAll(model2s);
        return models;
    }

}
