package com.jothmart.todobackend.security.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/api")
public class BasicAuthenticationController {

    //@GetMapping(path="/basic-auth")
    //@GetMapping("/basic-auth")
    public AuthenticationBean authenticateBasic() {
        System.out.println("Did I enter the authenticte basic method");
        return new AuthenticationBean("You are authenticated!");
    }

}
