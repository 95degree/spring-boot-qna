package com.codessquad.qna.controller;

import com.codessquad.qna.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(QuestionController.class);
    private List<User> users = new ArrayList<>();

    @PostMapping
    public String signup(User user) {
        users.add(user);
        logger.info(user.toString());
        return "redirect:/users";
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/{userId}")
    public String viewUserProfile(@PathVariable String userId, Model model) {
        for (User user : users) {
            if (user.isMatchingUserId(userId)) {
                model.addAttribute("user", user);
                return "user/profile";
            }
        }
        return "redirect:/users";
    }

    @GetMapping("{id}/form")
    public String viewUpdateUserForm(@PathVariable int id, Model model) {
        try {
            User user = users.get(id - 1);
            model.addAttribute("user", user);
            return "user/updateForm";
        } catch (IndexOutOfBoundsException e) {
            return "redircet:/users";
        }
    }

    @PostMapping("{id}/update")
    public String updateUser(@PathVariable int id, User updateUser) {
        try {
            User targetUser = users.get(id - 1);
            targetUser.setUser(updateUser);
            return "redirect:/users";
        }
        catch (IndexOutOfBoundsException e){
            return "redirect:/{id}/form";
        }
    }
}
