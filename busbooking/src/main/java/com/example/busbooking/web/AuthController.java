package com.example.busbooking.web;

import com.example.busbooking.model.User;
import com.example.busbooking.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String loginForm() { return "auth/login"; }

  @PostMapping("/login")
  public String doLogin(String email, String password, HttpSession session, Model model) {
    User user = userService.authenticate(email, password);
    if (user == null) {
      model.addAttribute("error", "Invalid credentials");
      return "auth/login";
    }
    session.setAttribute("userId", user.getId());
    session.setAttribute("userName", user.getName());
    return "redirect:/";
  }

  @GetMapping("/register")
  public String registerForm(Model model) {
    model.addAttribute("user", new User());
    return "auth/register";
  }

  @PostMapping("/register")
  public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "auth/register";
    }
    try {
      userService.register(user.getName(), user.getEmail(), user.getPasswordHash());
      model.addAttribute("msg", "Registration successful. Please login.");
      return "auth/login";
    } catch (IllegalArgumentException ex) {
      model.addAttribute("error", ex.getMessage());
      return "auth/register";
    }
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }
}


