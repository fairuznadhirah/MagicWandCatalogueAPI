package com.accenture.magicWand;

import com.accenture.magicWand.entity.Magic;
import com.accenture.magicWand.repository.MagicRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MagicControllerTest {

    @Autowired
    private MagicRepository magicRepository;

    private static final Logger log = LoggerFactory.getLogger(MagicControllerTest.class);

    @Test
    public void testCreate(){
        Magic magic = new Magic();
        magic.setMagic_id(1L);
        magic.setMagic_name("Hii");
        magic.setMagic_desc("hello world");
        magic.setMagic_age_limit(32);
        magic.setMagic_stock(42);
        magicRepository.save(magic);
        assertNotNull(magicRepository.findById(1L).get());
    }

    @Test
    public void testGetWizard(){
        List<Magic> list = magicRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void testGetIDWizard(){
        Magic magic = magicRepository.findById(2L).get();
        assertEquals(63, magic.getMagic_stock());
    }

    @Test
    public void testUpdateWizard(){
        Magic magic = magicRepository.findById(2L).get();
        magic.setMagic_name("Nadhirah");
        magicRepository.save(magic);
        assertNotEquals("Izdihar", magicRepository.findById(2L).get().getMagic_name());

    }

    @Test
    public void testDeleteWizard(){
        magicRepository.deleteById(3L);
        assertThat(magicRepository.existsById(3L)).isFalse();

    }
}
