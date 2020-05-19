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

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ControllerWiyRepository controllerWiyRepository;

    @GetMapping("/")
    public String admin() {
        return "admin/admin";
    }


//TODO: show controllers...
    @GetMapping("/user/{id}")
    public String users(@PathVariable Integer id,Model model) {
        //ModelAndView modelv = new ModelAndView("/admin/user");
        User user = userRepository.findById(id).orElse(new User());
        List<ControllerWiy> userControllers = controllerWiyRepository.findByOwner(id);
        model.addAttribute("user",user);
        model.addAttribute("controllers",userControllers);
        return "/admin/user";
    }


    @PostMapping("/users")
    public String userAdd(@ModelAttribute User user) {
        //ModelAndView model = new ModelAndView("admin/user");
        user.getUserRole().add(new Role("ROLE_USER"));
        userRepository.save(user);
        userRepository.flush();
        return "redirect:/admin/users";///{"+ user.getId().toString() +"}";
    }
    @GetMapping("/users")
    public String usersAll(Model model) {
        List<User> list = userRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("user",new User());
        return "/admin/users";
    }




    @GetMapping("/controllers")
    public String controllers() {
        return "admin";
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
