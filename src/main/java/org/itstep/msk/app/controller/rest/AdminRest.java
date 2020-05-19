package org.itstep.msk.app.controller.rest;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminRest {

    @Autowired
    UserRepository userRepository;

    @DeleteMapping("/users/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Integer id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.delete(user.get());
            userRepository.flush();
            return "OK";
        }
        throw new RuntimeException("Not Found");
    }

    @PostMapping("/users/block/{id}")
    @ResponseBody
    public String blockUser(@PathVariable Integer id,Model model){
        return "";
    }

}
