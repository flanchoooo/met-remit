package com.remit.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/user_type")
public class UserTypeController {

   /* @Autowired
    UserTypeServiceImpl userTypeService;

    @Resource
    UserTypeRepository userTypeRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<UserType> findAll(final Pageable pageable) throws EntityNotFoundException {
        return userTypeRepository.findAll(pageable);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody CreateUserTypeDto userTypeDto) throws Exception {
        return userTypeService.save(userTypeDto);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserType findById(@PathVariable String id) throws EntityNotFoundException {
        return userTypeRepository.findById(Integer.valueOf(id)).get();
    }

*/
}
