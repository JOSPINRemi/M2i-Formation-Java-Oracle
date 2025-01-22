package org.example.demosecujwtwebflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {
    @GetMapping("")
    public String hello() {
        return "Hello World si tu as un token";
    }
}
