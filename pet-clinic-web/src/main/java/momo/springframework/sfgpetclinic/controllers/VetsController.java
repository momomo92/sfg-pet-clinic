package momo.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("vets")
@Controller
public class VetsController {

    @RequestMapping("list")
    public String list() {
        return "vets/list";
    }
}
