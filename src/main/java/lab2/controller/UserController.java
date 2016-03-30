package lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import lab2.dao.UserDao;
import lab2.persistence.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping
    public ModelAndView save(ModelAndView  modelAndView) {
	modelAndView.setViewName("userForm");
	return modelAndView;
    }

    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public ModelAndView  save(@RequestParam(value="userName") String userName,
	   @RequestParam(value="age") int age, ModelAndView  modelAndView ) {
	        User user = new User(userName, age);
	        userDao.saveUserDetail(user);
	        modelAndView.addObject("userName", userName);
	        modelAndView.setViewName("success");
        return modelAndView;
   }
} 
