package com.hotelMS.controller;

import com.hotelMS.domain.Platform;
import com.hotelMS.service.impl.PlatformServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/platform")
public class PlatformController {

    @Autowired
    PlatformServiceImpl platformService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> save(@PathVariable int id) throws Exception {
        return platformService.findById(id);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Platform platform) throws Exception {
        return platformService.save(platform);
    }

}
