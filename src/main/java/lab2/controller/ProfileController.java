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
public class ProfileController
{

	@Autowired
	private IProfileDoa profileDoa;
	
	//Working
	@RequestMapping( method = RequestMethod.GET)
	public ModelAndView profileFormRedirect(ModelAndView modelAndView)
	{
		modelAndView.setViewName("profileForm");
		return modelAndView;
	}
	
	//Working
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName, @RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "address", required = false) String address, @RequestParam(value = "organization", required = false) String organization,
			@RequestParam(value = "aboutme", required = false) String aboutme, ModelAndView modelAndView)
	{
		Profile user = new Profile(firstName, lastName, email, address, organization, aboutme);
		profileDoa.saveUserDetail(user);
		modelAndView.addObject("userName", firstName + " " + lastName);
		modelAndView.setViewName("success");
		return modelAndView;
	}

	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public ModelAndView showProfile(@PathVariable("userId") int id,
			@RequestParam(value = "brief", required = false) String brief, ModelAndView modelAndView)
	{
		System.out.println("brief"+brief);
		
		if (brief.equals("true"))
		{ 
			
			System.out.println("brief inside MVC call");
			Profile user = profileDoa.getProfile(id);
			if (user != null)
			{
				System.out.println("brief inside MVC call 2");
				modelAndView.addObject("profile", user);
				modelAndView.setViewName("profiletext");
			}
			else
			{
				modelAndView.setViewName("error");
				modelAndView.addObject("message", "404 Requested id " + id + " not found");
			}
			return modelAndView;

		}
		else
		{
			Profile user = profileDoa.getProfile(id);
			if (user != null)
			{
				modelAndView.addObject("profile", user);
				modelAndView.setViewName("profile");
			}
			else
			{
				modelAndView.setViewName("error");
				modelAndView.addObject("message", "404 Requested id " + id + " not found");
			}
			return modelAndView;
		}
	}

	@RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
	public String deleteProfile(@PathVariable("userId") int id, ModelAndView modelAndView)
	{
		boolean res = profileDoa.deleteProfile(id);
		if (res == true)
		{
			return "redirect:/profile";
		}
		else
		{
			return "redirect:/error";
			/*
			 * modelAndView.setViewName("error");
			 * modelAndView.addObject("message","404 Requested id " +id+
			 * " not found");
			 */
		}

	}

	/*
	 * @RequestMapping(value="{userId}",method = RequestMethod.POST) public
	 * ModelAndView updateProfile(@PathVariable("userId") int id,
	 * 
	 * @RequestParam(value = "first_name",required=false) String firstName,
	 * 
	 * @RequestParam(value = "last_name",required=false) String lastName,
	 * 
	 * @RequestParam(value = "email",required=false) String email,
	 * 
	 * @RequestParam(value = "address",required=false) String address,
	 * 
	 * @RequestParam(value = "organization",required=false) String organization,
	 * 
	 * @RequestParam(value = "about_me",required=false) String aboutme,
	 * ModelAndView modelAndView) { Profile user = new Profile(firstName,
	 * lastName, email, address, organization, aboutme); Profile updatedUser =
	 * profileDoa.updateProfile(id, user);
	 * modelAndView.addObject("profile",updatedUser);
	 * modelAndView.setViewName("profile"); return modelAndView; }
	 */

	@RequestMapping(value = "{userId}", method = RequestMethod.POST)
	public @ResponseBody Profile updateProfile(@PathVariable("userId") int id,
			@RequestParam(value = "first_name", required = false) String firstName,
			@RequestParam(value = "last_name", required = false) String lastName,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "organization", required = false) String organization,
			@RequestParam(value = "about_me", required = false) String aboutme, ModelAndView modelAndView)
	{
		Profile user = new Profile(firstName, lastName, email, address, organization, aboutme);
		Profile updatedUser = profileDoa.updateProfile(id, user);

		return updatedUser;
	}

}
