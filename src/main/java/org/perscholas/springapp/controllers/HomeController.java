package org.perscholas.springapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@SessionAttributes({"theuser"})
//@RequestMapping("api/v1")
public class HomeController {
    //localhost:8080/ || localhost:8080/index || localhost:8080/Bobby
    // --> localhost:8080/api/v1/ || localhost:8080/api/v1index || localhost:8080/api/v1/Bobby
    @GetMapping("/listusers")
    public String listUser(Model model, @RequestParam("hello") int hello){
        List<User> listUsers = new ArrayList<User>();
        listUsers.add(new User( 1, "Freda", "Freda@Elmoselhi.org"));
        listUsers.add(new User( 2, "Tharwat", "Tharwat@Elmoselhi.org"));
        listUsers.add(new User( 3, "Amina", "Amina@Elmoselhi.org"));
        listUsers.add(new User( 4, "Muhammed", "Muhammed@Elmoselhi.org"));
        listUsers.add(new User( 5, "Arwa", "Arwa@Elmoselhi.org"));
        for(var list: listUsers){
           System.out.println(list.getId());
           System.out.println(list.getName());
           System.out.println(list.getEmail());
        }
        System.out.println("hello=" + hello);
        model.addAttribute("theList", listUsers);
        model.addAttribute("hello", hello);
        return "listusers";
    }

    @GetMapping(value = {"/", "/index", "Bobby"})
    public ModelAndView showIndex() {
        log.warn("Requested index");
       // User u1 = new User(1, "andrew", "andrewjdiner@gmail.com");
        //log.warn(u1.toString());
        ModelAndView mav = new ModelAndView("index");
       // mav.addObject("theuser", u1);
        return mav;
    }


    @PostMapping(value = "/process")
    public String showPage(@ModelAttribute("theuser") User u, Model model){
    model.addAttribute("theuser", u);
    return "showData";
    }

    @ModelAttribute("theuser")
    public User userInit(){
        return new User();
    }

//    @PostMapping(value = "/process")
//    public String showPage2(@RequestParam("id") int id,
//                            @RequestParam("name") String name,
//                            @RequestParam("email") String email,
//                            Model model){
//        User toomuchWork = new User(id, name, email);
//        model.addAttribute("thenewuser", toomuchWork);
//        return "showData";
//    }
}
