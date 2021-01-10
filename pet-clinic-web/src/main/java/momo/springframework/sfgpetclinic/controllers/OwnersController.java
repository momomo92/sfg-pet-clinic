package momo.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("owners")
@Controller
public class OwnersController {

    @RequestMapping("list")
    public String list() {
        return "owners/list";
    }
}
