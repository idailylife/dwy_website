package com.dianwuyou.web;

import com.dianwuyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by hebowei on 16/7/5.
 * Controls (user-specific) files that stored in database
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    UserService userService;


}
