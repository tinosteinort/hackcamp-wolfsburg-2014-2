package de.wolfsburg.hackcamp.business.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.wolfsburg.hackcamp.business.blog.persistence.BlogPostRepository;
import de.wolfsburg.hackcamp.business.blog.persistence.entity.BlogPost;
import de.wolfsburg.hackcamp.business.user.persistence.UserRepository;
import de.wolfsburg.hackcamp.business.user.persistence.entity.User;

@Controller
@RequestMapping("/create")
public class CreatePostController {
    
    @Autowired BlogPostRepository blogRepository;
    @Autowired UserRepository userRepository;
    
    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public ModelAndView handleRequest(@RequestParam("subject") String subject,
                                      @RequestParam("content") String content) throws Exception {

        final User defaultUser = userRepository.findUserByName("user");
        
        final BlogPost newPost = new BlogPost(defaultUser, subject, content);
        blogRepository.save(newPost);
        
        final ModelAndView modelAndView = new ModelAndView("app/createblogpost");
        modelAndView.addObject("blogPost", newPost);
        modelAndView.addObject("blogCount", blogRepository.countAll());

        return modelAndView;
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest() throws Exception {
        
        final ModelAndView modelAndView = new ModelAndView("app/createblogpost");
        modelAndView.addObject("blogCount", blogRepository.countAll());

        return modelAndView;
    }
}
