package com.demo.demospring.controller;

import com.demo.demospring.entity.WorkEntity;
import com.demo.demospring.model.request.WorkReq;
import com.demo.demospring.model.request.FilterReq;
import com.demo.demospring.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkController {
    @Autowired
    WorkService workService;

    @PostMapping("/works")
    public ResponseEntity<WorkEntity> createWork(@RequestBody @Valid WorkReq workReq) {
        ResponseEntity<WorkEntity> workEntityResponseEntity;
        workEntityResponseEntity   = workService.save(workReq);
        return workEntityResponseEntity;
    }

    @PutMapping("/works/{id}")
    public ResponseEntity<WorkEntity> updateWork(@PathVariable("id") long id, @RequestBody @Valid WorkReq workReq) {
        ResponseEntity<WorkEntity> workEntityResponseEntity;
        workEntityResponseEntity   = workService.update(id,workReq);
        return workEntityResponseEntity;
    }

    @DeleteMapping("/works/{id}")
    public ResponseEntity<WorkEntity> deleteWork(@PathVariable("id") long id) {
        ResponseEntity<WorkEntity> workEntityResponseEntity;
        workEntityResponseEntity   = workService.delete(id);
        return workEntityResponseEntity;
    }

    @GetMapping("/works")
    public List<WorkEntity> updateWork(@RequestParam FilterReq filterReq) {
        List<WorkEntity> list;
        list = workService.filter(filterReq);
        return list;
    }

}
