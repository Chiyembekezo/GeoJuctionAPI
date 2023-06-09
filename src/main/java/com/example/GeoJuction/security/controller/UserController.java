package com.example.GeoJuction.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.GeoJuction.security.model.User;
import com.example.GeoJuction.security.service.RoleService;
import com.example.GeoJuction.security.service.UserService;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/security/users")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/security/user_list";
    }

    @GetMapping("/security/users/addUser")
    public String addUser()
    {
        return "/security/user_add";
    }

    @GetMapping("/security/user/edit/{id}")
    public String userEdit(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return "/security/user_edit";
    }

    @RequestMapping(value ="/security/user/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView updateUser(@PathVariable Integer id, @ModelAttribute User updatedUser, RedirectAttributes redir) {
        User user = userService.findById(id);
        user.setFirstname(updatedUser.getFirstname());
        user.setLastname(updatedUser.getLastname());
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setAddress(updatedUser.getAddress());
        user.setDob(updatedUser.getDob());
        user.setGender(updatedUser.getGender());
        user.setNrcNumber(updatedUser.getNrcNumber());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        // user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        userService.save(user);

        RedirectView redirectView = new RedirectView("/security/user/edit/" + id, true);
        redir.addFlashAttribute("message", "User updated successfully!");
        return redirectView;
    }
    

    @RequestMapping(value = "/security/user/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/security/users";
    }

    @PostMapping("/users/addNew")
    public String addNew(User user, RedirectAttributes redir) {
        userService.save(user);
        redir.addFlashAttribute("message", "You have successfully registered a new user!");

        return "redirect:/security/user/edit/" + user.getId();
    }

    @GetMapping("/userProfile")
    public String userProfile(Model model, Principal principal)
    {
        String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));

        return "security/user_profile";
    }

}
