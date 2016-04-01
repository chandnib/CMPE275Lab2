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

	// Working
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView profileFormRedirect(ModelAndView modelAndView) {
		modelAndView.setViewName("profileForm");
		return modelAndView;
	}

	// Working
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "organization", required = false) String organization,
			@RequestParam(value = "aboutme", required = false) String aboutme, ModelAndView modelAndView) {
		try {
			Profile user = new Profile(firstName, lastName, email, address, organization, aboutme);
			int profileId = profileDoa.saveUserDetail(user);
			return new ModelAndView("redirect:/profile/" + profileId);
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("error");
			modelAndView.addObject("message",
					"500 Internal Server Error : There was an error Processing your Request!!");
			return modelAndView;
		}
	}

	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public ModelAndView showProfile(@PathVariable("userId") int id,
			@RequestParam(value = "brief", required = false, defaultValue = "false") String brief,
			ModelAndView modelAndView) {
		Profile user =  null;
		try {
			user = profileDoa.getProfile(id);
			if (user != null) {
				modelAndView.addObject("profile", user);
				if (brief.equals("true")) {
					modelAndView.setViewName("profiletext");
				} else {
					modelAndView.setViewName("profile");
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("error");
			modelAndView.addObject("message", "Sorry, the requested user with ID " + id + " does not exist");
		}
		return modelAndView;
	}

	@RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
	public String deleteProfile(@PathVariable("userId") int id, ModelAndView modelAndView) {
		boolean res;
		try {
			res = profileDoa.deleteProfile(id);
			if (res == true) {
				return "redirect:/profile";
			} else {
				return "redirect:/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}
	}

	@RequestMapping(value = "{userId}", method = RequestMethod.POST)
	public @ResponseBody Profile updateProfile(@PathVariable("userId") int id,
			@RequestParam(value = "first_name", required = false) String firstName,
			@RequestParam(value = "last_name", required = false) String lastName,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "organization", required = false) String organization,
			@RequestParam(value = "about_me", required = false) String aboutme, ModelAndView modelAndView) {
		Profile user = null;
		Profile updatedUser = null;
		try {
			user = new Profile(firstName, lastName, email, address, organization, aboutme);
			updatedUser = profileDoa.updateProfile(id, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedUser;
	}

}
