package de.wolfsburg.hackcamp.business.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.wolfsburg.hackcamp.business.blog.persistence.BlogPostRepository;

@Controller
@RequestMapping("/")
public class EntryPoint {
    
    @Autowired BlogPostRepository blogRepository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public ModelAndView handleRequest() throws Exception {

        final ModelAndView modelAndView = new ModelAndView("app/index");
        modelAndView.addObject("blogPosts", blogRepository.findBlogPosts());
        modelAndView.addObject("blogCount", blogRepository.countAll());

        return modelAndView;
    }
}
