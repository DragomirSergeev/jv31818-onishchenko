package org.itstep.msk.app.controller.rest;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ArrayList<String> blockUser(@PathVariable Integer id, @RequestParam Integer enable){
        Optional<User> opt = userRepository.findById(id);
        ArrayList<String> list = new ArrayList<>();
        if(opt.isPresent()) {
            System.out.println(opt.get().getUsername()+" exists.");
            if (enable == 1) {
            opt.get().setEnabled(true);
            } else if (enable == 0) {
                opt.get().setEnabled(false);
            } else {
                list.add("ERROR: wrong value for enable field: must be 1 or 0.");
                return list;
            }
            userRepository.save(opt.get());
            userRepository.flush();
        }else{
            list.add("No such user id");
            return list;
        }
        list.add("OK");
        return list;
    }

}
