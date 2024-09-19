package me.pe4en1e.ttm_backend.route;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root {

    @GetMapping("/")
    public String root() {
        return "Hello! This is the root page!";
    }


}
