package www.silver.hom;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// value : Client�� ��û�� ��û�м�
	// http://localhost:8080/hom/WEB-INF/classes/www/silver/hom/HomeController.java
	// ���� ~/hom/WEB-INF/classes/www/silver/hom/HomeController.java �ش�ȴ�.
	// hom : Context Path
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "timeline", method = RequestMethod.GET)
	public String timeline() {
		return "timeline";
	}
	
	@RequestMapping(value = "viewMessage", method = RequestMethod.GET)
	public String viewMessage_get(@RequestParam("time") String time, @RequestParam("name") String name, 
			Model model) {
		// 디버깅
//		System.out.println(time + " / " + name);
//		ModelAndView mav = new ModelAndView();
		model.addAttribute("변수명", "값");
		model.addAttribute("time", time);
		model.addAttribute("name", name);
		model.addAttribute("age", 100);
		return "viewMsg";
	}
	
	@RequestMapping(value = "viewMessage", method = RequestMethod.POST)
	public String viewMessage_post(@RequestParam("time") String time, @RequestParam("name") String name, 
			Model model) {
		// 디버깅
//		System.out.println(time + " / " + name);
//		ModelAndView mav = new ModelAndView();
		model.addAttribute("변수명", "값");
		model.addAttribute("time", time);
		model.addAttribute("name", name);
		model.addAttribute("age", 100);
		return "viewMsg";
	}
	
}
