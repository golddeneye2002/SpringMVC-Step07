package com.in28minutes.login;


import com.in28minutes.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    //Set the log in service - Auto wiring
    @Autowired
    LoginService loginService ;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    //@ResponseBody
    public String showLoginPage(){
        //return "Hellow World I am testing ----";
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    //@ResponseBody
    public String handleLoginREquest(
            @RequestParam String name,
            @RequestParam String password,
            ModelMap model){

        if(loginService.validateUser(name, password)) {
            model.put("name", name);
            model.put("password", password);

            System.out.println(name);
            //return "Hellow World I am testing ----";
            return "welcome";
        }else{

            model.put("errorMessage", "not valid user");
            return "login";
        }
    }


}

