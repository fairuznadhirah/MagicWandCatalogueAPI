package com.accenture.magicWand.service;

import com.accenture.magicWand.entity.Magic;
import com.accenture.magicWand.exceptions.MagicException;
import com.accenture.magicWand.repository.MagicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MagicService {

    @Autowired
    MagicRepository magicRepository;

    public Magic addMagic(Magic magic){
        return magicRepository.save(magic);
    }

    public List<Magic> getMagics(){
        return magicRepository.findAll();
    }

    public void deleteMagic(Long magic_id){
        magicRepository.findById(magic_id).orElseThrow(
                () -> new MagicException(MagicException.INVALID_EXIST_WIZARD)
        );
        magicRepository.deleteById(magic_id);
    }

    public Magic updateMagic(Long magic_id, Magic magic){
        magicRepository.findById(magic_id).orElseThrow(
                () -> new MagicException("Magic with id= " + magic.getMagic_id() + " does not exist")
        );
        return magicRepository.save(magic);
    }
}
