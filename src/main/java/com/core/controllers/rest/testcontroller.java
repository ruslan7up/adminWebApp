package com.core.controllers.rest;

import com.core.services.qwe;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ruslan on 12.01.2017.
 */

@RestController
public class testcontroller {
    @RequestMapping(value = "/qwe",method = RequestMethod.GET)
    public qwe returnjson() {
      qwe fdg = new qwe() ;
        fdg.setInteg(23);
        fdg.setText("rtret");
        return fdg;
    };
}
