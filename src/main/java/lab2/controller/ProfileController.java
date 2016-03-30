package lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import lab2.dao.ProfileDao;
import lab2.persistence.Profile;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileDao profileDoa;

	@RequestMapping
	public ModelAndView save(ModelAndView modelAndView) {
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
			ModelAndView modelAndView) {
		Profile user = new Profile(firstName, lastName, email, address, organization, aboutme);
		profileDoa.saveUserDetail(user);
		modelAndView.addObject("userName", firstName + " " + lastName);
		modelAndView.setViewName("success");
		return modelAndView;
	}
}
