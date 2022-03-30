package com.demo.demospring.service;

import com.demo.demospring.entity.WorkEntity;
import com.demo.demospring.model.request.WorkReq;
import com.demo.demospring.model.request.FilterReq;
import com.demo.demospring.repository.WorkRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class WorkService {

    private final WorkRepository workRepository;

    public ResponseEntity<WorkEntity> save(WorkReq workReq){
        try {
            WorkEntity workEntity = workRepository
                    .save(new WorkEntity(workReq.getWorkName(), workReq.getEndDate(), workReq.getStartDate(),workReq.getStatus().getValue()));
            return new ResponseEntity<>(workEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<WorkEntity> update(Long id, WorkReq workReq){
        Optional<WorkEntity> workEntityData = workRepository.findById(id);
        if (workEntityData.isPresent()) {
            WorkEntity workEntity1 = workEntityData.get();
            workEntity1.setWorkName(workReq.getWorkName());
            workEntity1.setEndDate(workReq.getEndDate());
            workEntity1.setStartDate(workReq.getStartDate());
            workEntity1.setStatus(workReq.getStatus().getValue());
            return new ResponseEntity<>(workRepository.save(workEntity1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<WorkEntity> delete(Long id){
        try {
            workRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<WorkEntity> filter(FilterReq filterReq){
        Page<WorkEntity> page = workRepository.findAll(PageRequest.of(filterReq.getPage(), filterReq.getSize(), Sort.by("start date").descending()));
        return page.getContent();
    }
}

