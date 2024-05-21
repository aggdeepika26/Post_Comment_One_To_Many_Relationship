package com.example.jpa.Controller;

import com.example.jpa.Service.CommentServiceImpl;
import com.example.jpa.Service.PostServiceImpl;
import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/postComment")
public class HomePagePostController {
    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private PostRepository postRepository;


    @GetMapping({"/showPosts", "/", "/list"})
    public ModelAndView showPosts() {
        ModelAndView mav = new ModelAndView("index");
        List<Post> list = postService.getAllPost();
        mav.addObject("listPosts", list);
        return mav;
    }


    @GetMapping("/showNewPostForm")
    public ModelAndView showNewPostForm() {
        ModelAndView mav = new ModelAndView("new_post");
        Post newPost = new Post();
        mav.addObject("post", newPost);
        return mav;
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdate")
    public ModelAndView showFormForUpdate(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("new_post");
        Post post = postService.getPostById(id);
        mav.addObject("post", post);
        return mav;
    }


    @GetMapping("/deletePost")
    public String deletePost(@RequestParam Long id) {
        //call delete employee method
        this.postService.deletePostById(id);
        return "redirect:/";
    }
  //*********************************************************************************


  // @GetMapping("/getPostToAddComment/{id}")
  @GetMapping("/getPostToAddComment")
  public ModelAndView getPostToAddComment(@RequestParam Long id) {
      ModelAndView mav = new ModelAndView("add_comment");
      Post post = postService.getPostById(id);
      Comment comment = new Comment();
      comment.setPost(post);
      mav.addObject("post", post);
      mav.addObject("comment", comment);
      return mav;
  }


    @PostMapping("/saveComment")
    public String saveComment(@ModelAttribute Comment comment) {
        System.out.println("hello " + comment.getPost().getId());
        commentService.addCommentToPost(comment.getPost().getId(), comment);
        return "redirect:/" ;
    }

   /* @PostMapping("/saveComment")
    public String saveComment(@RequestParam Long id,@ModelAttribute Comment comment) {
        commentService.addCommentToPost(id, comment);
        return "redirect:/";
    }

   /* public String getPostToAddComment(@PathVariable Long id, Model model)
  public String getPostToAddComment(@RequestParam Long id, Model model)
  {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment());
        return "post";
    }

    @PostMapping("/{id}/comments")
    public String addComment(@PathVariable Long id, @ModelAttribute Comment comment) {
        commentService.addCommentToPost(id, comment);
        return "redirect:" + id;
    }*/




}





     /*  @GetMapping("/")
   public String viewHomePage(Model model)
    {
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    }*/



    /*  @GetMapping("/showNewEmployeeForm")
        public String showNewEmployeeForm(Model model)
      {
          Employee employee = new Employee();
          model.addAttribute("employee", employee);
          return "new_employee";
      }*/

/*  @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model) {
        //get employee from the services
        Employee employee = employeeService.getEmployeeById(id);
        //set employee as a model attribute to preopulate the form
        model.addAttribute("employee",employee);
        return  "update_employee";
    }*/




  /*  @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id)
    {
        //call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }*/



