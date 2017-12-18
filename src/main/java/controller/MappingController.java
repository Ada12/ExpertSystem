package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yangchen on 17/7/2.
 */
@Controller
public class MappingController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String getLogin(){
        return "login";
    }

    @RequestMapping(value = "design", method = RequestMethod.GET)
    public String getDesign(){
        return "design";
    }

    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String getHistory(){
        return "history";
    }

}
