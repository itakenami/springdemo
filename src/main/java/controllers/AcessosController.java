package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/acessos")
public class AcessosController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView resultado = new ModelAndView();
        resultado.setViewName("acessos/login");
        return resultado;
    }
    
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message","Erro ao efetuar login. Tente novamente.");
        return "redirect:/acessos/login";
    }
    
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public ModelAndView denied() {
        ModelAndView resultado = new ModelAndView();
        resultado.setViewName("acessos/denied");
        return resultado;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/j_spring_security_logout";
    }
    
}
