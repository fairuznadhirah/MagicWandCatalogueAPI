package com.accenture.magicWand.controller;


import com.accenture.magicWand.entity.Magic;
import com.accenture.magicWand.repository.MagicRepository;
import com.accenture.magicWand.service.MagicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magic")
public class magicController {

    @Autowired
    private final MagicRepository magicRepository;

    @Autowired
    MagicService magicService;

    private static final Logger logger = LoggerFactory.getLogger(magicController.class);

    public magicController(MagicRepository magicRepository) {
        this.magicRepository = magicRepository;
    }

    @GetMapping("/magicAll")
    public List<Magic> getMagics_id(){
        return magicService.getMagics();
    }

    @PostMapping("/add")
    public Magic addMagic(@RequestBody Magic magic){
        return magicService.addMagic(magic);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMagic(@PathVariable(value = "id") long id){
        magicService.deleteMagic(id);
    }

    @PutMapping("/update/{id}")
    public Magic updateMagic(@PathVariable Long magic_id, @RequestBody Magic magic) {
        return magicService.updateMagic(magic_id,magic);
    }

}
