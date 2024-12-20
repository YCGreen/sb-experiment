package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//http://localhost:8080/
@Controller
public class DictionaryController {
    private final EnglishDictionary ed = new EnglishDictionary();

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("textBoxValue", "Hello, World!");
        model.addAttribute("def", null);
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("inputText") String inputText, Model model) {
        model.addAttribute("textBoxValue", inputText);
        String def = ed.getAllDefinitions(inputText);
        model.addAttribute("def", def);

        return "form";
    }

}