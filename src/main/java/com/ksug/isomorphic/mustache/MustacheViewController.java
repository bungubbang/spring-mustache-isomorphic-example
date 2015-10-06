package com.ksug.isomorphic.mustache;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

/**
 * Created by 1000742
 * Email: sungyong.jung@sk.com
 * Date: 2015. 10. 6.
 */
@Controller
public class MustacheViewController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "KSUG 2015 Web Seminar");
        model.addAttribute("subject", "Spring Isomorphic example");
        model.addAttribute("list", Arrays.asList("Mustache", "Handlebars", "React"));
        return "index";
    }
}
