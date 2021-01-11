package momo.springframework.sfgpetclinic.controllers;

import momo.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("owners")
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("owners", ownerService.findAll());

        return "owners/list";
    }
}
