package lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lab2.dao.IProfileDoa;
import lab2.dao.ProfileDao;
import lab2.persistence.Profile;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private IProfileDoa profileDoa;

	@RequestMapping
	public ModelAndView profileFormView(@RequestParam(value = "brief", defaultValue = "false") String brief,ModelAndView modelAndView) 
	{
		System.out.println("brief == > " + brief);
		modelAndView.setViewName("profileForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView profileFormRedirect(ModelAndView modelAndView) 
	{
		modelAndView.setViewName("profileForm");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(
			@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "organization") String organization,
			@RequestParam(value = "aboutme") String aboutme,
			ModelAndView modelAndView) 
	{
		Profile user = new Profile(firstName, lastName, email, address, organization, aboutme);
		profileDoa.saveUserDetail(user);
		modelAndView.addObject("userName", firstName + " " + lastName);
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping(value="{userId}",method = RequestMethod.GET)
	public ModelAndView showProfile(@PathVariable("userId") int id,ModelAndView modelAndView)
	{
	    Profile user = profileDoa.getProfile(id);
	    if(user!=null) 
	    {
	    modelAndView.addObject("profile",user);
	    modelAndView.setViewName("profile");
	    }
	    else 
	    {
	    	modelAndView.setViewName("error");
	    	modelAndView.addObject("message","404 Requested id " +id+ " not found");
	    }
		return modelAndView;
	}
	
	@RequestMapping(value="{userId}",method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteProfile(@PathVariable("userId") int id,ModelAndView modelAndView)
	{
		boolean res = profileDoa.deleteProfile(id);
		return res;
		/*if(res==true) 
		{
			return "redirect:/profile" ;
		}
		else
		{
			return "redirect:/error" ;
			modelAndView.setViewName("error");
	    	modelAndView.addObject("message","404 Requested id " +id+ " not found");
		}*/
		
		
	}
	
	@RequestMapping(value="{userId}",method = RequestMethod.POST)
	public ModelAndView updateProfile(@PathVariable("userId") int id,
			@RequestParam(value = "first_name",required=false) String firstName,
			@RequestParam(value = "last_name",required=false) String lastName,
			@RequestParam(value = "email",required=false) String email,
			@RequestParam(value = "address",required=false) String address,
			@RequestParam(value = "organization",required=false) String organization,
			@RequestParam(value = "about_me",required=false) String aboutme,
			ModelAndView modelAndView)
	{
		Profile user = new Profile(firstName, lastName, email, address, organization, aboutme);
		Profile updatedUser = profileDoa.updateProfile(id, user);
		 modelAndView.addObject("profile",updatedUser);
	     modelAndView.setViewName("profile");
		return modelAndView;
	}
	
	
	
}
