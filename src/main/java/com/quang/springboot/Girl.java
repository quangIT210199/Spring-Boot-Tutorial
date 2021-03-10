package com.quang.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Girl {


    @Qualifier("Dress")
    @Autowired
    Outfit outfit;

    public Girl(@Qualifier("Dress") Outfit outfit) {
        this.outfit = outfit;
    }

//    @Override
//    public void he() {
//        System.out.println("HEHEHE");
//    }

    // GET
    // SET
}
