package com.example.multi_mongodb_project.controller.model2;

import com.example.multi_mongodb_project.model2.Model2;
import com.example.multi_mongodb_project.service.Model2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RestController
@RequestMapping("api/model2")
@RequiredArgsConstructor
public class Model2Controller {
    private final Model2Service model2Service;

    @PostMapping("addModel2")
    Model2 addModel2(@RequestBody Model2 model2) {
        return model2Service.addModel2(model2);
    }

    @PostMapping("initializeModel2")
    void initializeModel2(@RequestBody List<Model2> model2s) {
        model2Service.initializeModel2(model2s);
    }

    @DeleteMapping("deleteModel2/{id}")
    void deleteModel2(@PathVariable String id) {
        model2Service.deleteModel2(id);
    }

    @DeleteMapping("destroyModel2s")
    void destroyModel2s() {
        model2Service.destroyModel2s();
    }

    @PutMapping("updateModel2")
    Model2 updateModel2(@PathVariable String id, @RequestBody Model2 newModel2) {
        return model2Service.updateModel2(id, newModel2);
    }


    @GetMapping("getModel2/{id}")
    Model2 getModel2(@PathVariable String id) {
        return model2Service.getModel2(id);
    }

    @GetMapping("getAllModel2s")
    List<Model2> getAllModel2s() {
        return model2Service.getAllModel2s();
    }
}
