package backend.controller;

import backend.model.Blog;
import backend.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/"})
public class BlogController {
    @Autowired
    public IBlogService blogService;

    @GetMapping
    public ModelAndView showListStudent() {
        List<Blog> blogList = blogService.findAll();
        ModelAndView view = new ModelAndView("blog/list");
        view.addObject("blogList", blogList);
        return view;
    }

    @PostMapping("/search")
    public ModelAndView showListSearch(@RequestParam String search) {
        List<Blog> blogList = blogService.findByName(search);
        ModelAndView view = new ModelAndView("blog/list");
        view.addObject("blogList", blogList);
        return view;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView view = new ModelAndView("blog/create");
        Blog blog = new Blog();
        view.addObject("blog", blog);
        return view;
    }

    @PostMapping("/create")
    public String actionCreate(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String actionDelete(@PathVariable Long id) {
        blogService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView view = new ModelAndView("blog/edit");
        view.addObject("blog", blog);
        return view;
    }

    @PostMapping("/edit")
    public String actionEdit(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        ModelAndView view = new ModelAndView("blog/detail");
        Blog blog = blogService.findById(id);
        view.addObject("blog", blog);
        return view ;
    }
}
