package com.remit.controller;

import com.remit.domain.Access;
import com.remit.repository.AccessRepository;
import com.remit.service.impl.AccessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

@RestController
@CrossOrigin
@RequestMapping(value = "access")
public class AccessController {

    @Autowired
    AccessServiceImpl accessService;

    @Resource
    AccessRepository accessRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Access> findAll(final Pageable pageable) throws EntityNotFoundException {
        return accessRepository.findAll(pageable);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Access findById(@PathVariable String id) throws EntityNotFoundException {
        return accessRepository.findById(Integer.valueOf(id)).get();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Access access) throws Exception {
        return accessService.save(access);
    }
}
