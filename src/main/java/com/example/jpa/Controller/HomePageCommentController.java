package com.example.jpa.Controller;

import com.example.jpa.Service.CommentServiceImpl;
import com.example.jpa.Service.PostServiceImpl;
import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomePageCommentController {
    @Autowired

    private CommentServiceImpl commentService;
    @Autowired
    private PostServiceImpl postService;



     /* @GetMapping("/showComment")
       public ModelAndView showComment() {
        ModelAndView mav = new ModelAndView("comment-index");
        List<Comment> list = commentService.getAllComment();
        mav.addObject("listComments", list);
        return mav;
    }*/


  /*  @GetMapping("/showNewCommentForm")
    public ModelAndView showNewCommentForm() {
        ModelAndView mav = new ModelAndView("add_comment");
        Comment newComment = new Comment();
        mav.addObject("comment", newComment);
        return mav;
    }

    @GetMapping("/showNewCommentForm")
    public ModelAndView showNewCommentForm(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("add_comment");

        Post post = postService.getPostById(id);
        Comment newComment = new Comment();
       // mav.addObject("comment", comment);
        mav.addObject("postId", post.getId());
        mav.addObject("comment", newComment);
        return mav;
    }
    @PostMapping("/saveMyComment")
    public String saveMyComment(@ModelAttribute("comment") Comment comment) {
        commentService.saveComment(comment);
        return "redirect:/";
    }*/


    @GetMapping("/showFormForUpdateComment")
    public ModelAndView showFormForUpdateComment(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("add_comment");
        Comment comment = commentService.getCommentById(id);
        mav.addObject("comment", comment);
        return mav;
    }


    @GetMapping("/deleteComment")
    public String deleteComment(@RequestParam Long id) {
        //call delete employee method
        this.commentService.deleteCommentById(id);
        return "redirect:/";
    }

}



