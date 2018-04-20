package com.example.websocketdemo.web.controller.admin.post;


import com.example.websocketdemo.service.post.PostService;
import com.example.websocketdemo.web.controller.AbstractBaseController;
import com.example.websocketdemo.web.form.PostCreateForm;
import com.example.websocketdemo.web.support.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin_")
public class PostCreateController extends AbstractBaseController {

    @Autowired
    private PostService postService;

    @PostMapping("post/create")
    public ResponseEntity<Response> newPost(@RequestBody @Valid PostCreateForm postJson,
                                            BindingResult bindingResult, Model model) throws IOException {
        Map<String, String> errors = null;
        if(bindingResult.hasErrors()){
            errors = bindingResult.getFieldErrors().stream()
                    .collect(
                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                    );
            return responseUtil.errorResponse(postJson, errors);
        }
        return responseUtil.successResponse(postService.add(postJson.convertToPost()), errors);
    }

}
