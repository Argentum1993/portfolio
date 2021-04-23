package test.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.portfolio.service.ProjectService;
import test.portfolio.service.PushSwapService;

@Controller
public class ProjectController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/push_swap", method = RequestMethod.GET)
    public ModelAndView pushSwapPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("push_swap");
        return modelAndView;
    }
    @RequestMapping(value = "/push_swap", method = RequestMethod.POST)
    public @ResponseBody
    String pushSwapService(@RequestParam(required = false) String data) {
        ProjectService service = new PushSwapService();
        String commands = service.exec(data);
        return commands;
    }
}