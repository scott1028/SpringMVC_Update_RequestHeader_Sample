package com.baseweb.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.*;
import com.baseweb.UserDao;

@RequestMapping("/authctl")
@Controller
public class AuthCtl {

    // @RequestMapping(method = RequestMethod.POST, value = "{id}")
    // public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    // }

    // @RequestMapping
    // public String index() {
    //     return "authctl/index";
    // }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<String> login(HttpServletRequest request) {
        System.out.println("In Login Controller Start");
        try{
            System.out.println(request.getSession().getAttribute("userObj").toString());
        }
        catch(Exception e){
            System.out.println("There is no any sessionId in this Request Header.");
        }

        System.out.println("Try to get user_id in http header start");
        try{
            System.out.println(request.getHeader("userObj"));
        }
        catch(Exception e){
            System.out.println("There is no any userId in this Request Header.");
        }
        System.out.println("Try to get user_id in http header end");

        System.out.println(request.getSession().getId());
        HttpHeaders responseHeaders = new HttpHeaders();

//        UserDao obj = new UserDao();
//        obj.setUser_id("guest");
//        request.getSession().setAttribute("userObj", obj);
        // try {
        //     UserDao.findAllDaoUsers().get(0).remove();
        // }
        // catch(Exception e){ }
        // return new ResponseEntity<String>(Integer.toString(UserDao.findAllDaoUsers().size()), responseHeaders, HttpStatus.ACCEPTED);
        System.out.println("In Login Controller End");
        return new ResponseEntity<String>("hi", responseHeaders, HttpStatus.OK);
    }
}
