package data_binding.session08bt04.controller;

import data_binding.session08bt04.model.dto.Register;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")
public class RegisterController {
    @GetMapping("/add")
    public String addMember(Model model) {
        model.addAttribute("member", new Register());
        return "addRegister";
    }

    @PostMapping("/add")
    public String addMember(@Valid @ModelAttribute("member") Register member, BindingResult result, Model model) {
        System.out.println(">>> password: " + member.getPassword());
        System.out.println(">>> confirm: " + member.getConfirmPassword());
        if (result.hasErrors()) {
            model.addAttribute("member", member);
            return "addRegister";
        }
        if (!member.getPassword().equals(member.getConfirmPassword())) {
            result.rejectValue(
                    "confirmPassword",
                    "error.confirmPassword",
                    "Mật khẩu không khớp"
            );
            return "addRegister";
        }
        return "success";
    }
}
