package org.itstep.msk.app.controller.front.admin;


import org.itstep.msk.app.repository.ControllerWiyRepository;
import org.itstep.msk.app.repository.RoleRepository;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminWiyControllers {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ControllerWiyRepository controllerWiyRepository;

    @GetMapping("/controllers")
    public String controllers() {
        return "admin";
    }
}
