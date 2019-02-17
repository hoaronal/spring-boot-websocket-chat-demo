package com.example.websocketdemo.web.controller.guest;

import com.example.websocketdemo.domain.PaggingResult;
import com.example.websocketdemo.domain.Post;
import com.example.websocketdemo.domain.User;
import com.example.websocketdemo.model.PostSearchRequest;
import com.example.websocketdemo.service.post.PostService;
import com.example.websocketdemo.service.user.UserService;
import com.example.websocketdemo.web.support.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    /*@Autowired
    private IUserService service;

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;*/

    @Inject
    private PaggingResult paggingResult;

    @GetMapping({"/"})
    public String dashboard(@RequestParam(defaultValue = "") String keyword,
                            @PageableDefault(50) Pageable pageable,
                            Model model,
                            HttpServletRequest servletRequest) {
        PostSearchRequest request = new PostSearchRequest("vi").withKeyword(keyword);
        Page<Post> posts = postService.getPosts(request, pageable);
        model.addAttribute("keyword", keyword);
        model.addAttribute("listItem", posts.getContent());
        model.addAttribute("pageable", pageable);
        model.addAttribute("pagination", new Pagination<>(posts, servletRequest));
        return "guest/index";
    }

    @GetMapping("bai-viet/{code}")
    public String newPost(@PathVariable("code") long code, Model model, HttpServletRequest request){
        try {
            /*if(!StringUtils.isBlank(request.getParameter("next"))){
                post = postService.getDetailNextOrPrev("next", Long.parseLong(request.getParameter("id")));
            }else if(!StringUtils.isBlank(request.getParameter("prev"))){
                post = postService.getDetailNextOrPrev("prev", Long.parseLong(request.getParameter("id")));
            }else{

            }*/
            Post post = postService.getPostById(code);
            model.addAttribute("item",post);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "guest/post/detail";
    }

    @GetMapping("getuser")
    public String get(Model model, @RequestParam(required = false,defaultValue = "1") int pageNumber,
                      @RequestParam(required = false,defaultValue = "50") int pageSize){
        User users = userService.getByEmail("hoa9x3@gmail.com");
        model.addAttribute("users", users);

        return "admin/index";
    }

    @GetMapping("comments")
    public String comments(Model model, @RequestParam(required = false,defaultValue = "1") int pageNumber,
                           @RequestParam(required = false,defaultValue = "50") int pageSize){

        return "admin/index";
    }

    @GetMapping("/lien-he")
    public String contact(Model model){
        return "guest/contact";
    }

    @GetMapping("/gioi-thieu")
    public String about(Model model){
        return "guest/about";
    }

    @GetMapping("chat-box")
    public String chatbox(Model model){
        return "index";
    }

    @GetMapping("chat")
    public String chat(Model model){
        return "chat";
    }

    /*@GetMapping(value = "login")
    public String loginPage(){
        return "guest/login";
    }*/
}
