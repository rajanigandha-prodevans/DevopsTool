package com.prodevans.DevOpsAssessmentTool.home;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/")
public class HomeController {
	// Initialization of the logger factory
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//	@GetMapping(value = {"dashboard", "login","register","assessment/**"})
//	public String getLandingPage(Model model) {
//		logger.info("Londing page has been initiated");
//		return "redirect:/";
//	}
	@RequestMapping(method = RequestMethod.GET, value = "logout")
    @ResponseBody
    public void SimpleLogout(HttpServletRequest request) throws ServletException {
    	request.logout();
    }
	
}
