package org.itstep.msk.app.controller.front.admin;

import org.itstep.msk.app.entity.ControllerWiy;
import org.itstep.msk.app.entity.Role;
import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.ControllerWiyRepository;
import org.itstep.msk.app.repository.RoleRepository;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {



    @GetMapping("/")
    public String admin() {
        return "admin/admin";
    }









    @GetMapping("/monitoring")
    public String monitoring() {
        return "admin";
    }

    @GetMapping("/settings")
    public String settings() {
        return "admin";
    }

    @GetMapping("/mailsend")
    public String mail() {
        return "admin";
    }

}
