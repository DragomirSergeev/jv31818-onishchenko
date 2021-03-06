package org.itstep.msk.app.controller.front.admin;

import org.itstep.msk.app.entity.ControllerWiy;
import org.itstep.msk.app.entity.Role;
import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.ControllerWiyRepository;
import org.itstep.msk.app.repository.RoleRepository;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Controller
@RequestMapping("/admin")
public class AdminUsers {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ControllerWiyRepository controllerWiyRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
//    @Autowired
//    BCryptPasswordEncoder bcryptEncoder;

    @GetMapping("/user/{id}")
    public String users(@PathVariable Integer id, Model model) {
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
        Set<Role> defaultRoles = new HashSet<>();
        user.setUserRole(defaultRoles);
        Optional<Role> rl = roleRepository.findById(2);
        Role role = rl.get();
        user.getUserRole().add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        userRepository.flush();
        return "redirect:/admin/users";///{"+ user.getId().toString() +"}";
    }
    @GetMapping("/users")
    public String usersAll(Model model) {
        return usersAllPages(model,0,50);
    }
    @GetMapping("/users/{start}&{end}")
    public String usersAllPages(Model model,int startIndex,int endIndex){
        List<User> list = userRepository.findAll();
        List<Integer> pages = new ArrayList<>();
        for(int i=0;i<list.size()/50;i++){
            pages.add(i+1);
        }
        model.addAttribute("pages",pages);
        model.addAttribute("list", list.subList(startIndex,list.size()>endIndex?endIndex:list.size()));
        model.addAttribute("user",new User());
        return "/admin/users";
    }
}
