package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Contato;
import dao.ContatoDao;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contatos")
public class ContatosController {

    @Autowired
    ContatoDao dao;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(final RedirectAttributes redirectAttributes) {

        ModelAndView resultado = new ModelAndView();
        resultado.setViewName("contatos/index");
        
        List<Contato> contatos = dao.findAll();
        resultado.getModel().put("contatos", contatos);
        
        return resultado;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form() {
        
        ModelAndView resultado = new ModelAndView();
        resultado.setViewName("contatos/form");
        
        
        Contato contato = new Contato();
        resultado.getModel().put("contato", contato);
        
        return resultado;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public ModelAndView form(@PathVariable("id") Long id) {
        
        ModelAndView resultado = new ModelAndView();
        resultado.setViewName("contatos/form");
        
        Contato contato = dao.findById(id); 
        resultado.getModel().put("contato", contato);
        
        return resultado;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Contato contato, BindingResult bindingResult, Map<String, Object> model, final RedirectAttributes redirectAttributes) {
        
        if(bindingResult.hasErrors()){
            model.put("contato", contato);
            return "contatos/form";
        }
        
        dao.save(contato);
        
        redirectAttributes.addFlashAttribute("message","Registro gravado com sucesso.");
        return "redirect:/contatos";
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, Contato contato, final RedirectAttributes redirectAttributes) {
        
        Contato c = dao.findById(id);
        BeanUtils.copyProperties(contato, c);
        dao.save(c);
        
        redirectAttributes.addFlashAttribute("message","Registro atualizado com sucesso.");
        return "redirect:/contatos";
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
        
        Contato c = dao.findById(id);
        dao.delete(c);
        
        redirectAttributes.addFlashAttribute("message","Registro exclu’do com sucesso.");
        return "redirect:/contatos";
    }
}
