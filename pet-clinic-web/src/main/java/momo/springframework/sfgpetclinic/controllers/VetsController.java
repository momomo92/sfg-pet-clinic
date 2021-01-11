package momo.springframework.sfgpetclinic.controllers;

import momo.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("vets")
@Controller
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("vets", vetService.findAll());

        return "vets/list";
    }
}
