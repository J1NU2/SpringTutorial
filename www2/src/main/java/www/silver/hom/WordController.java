package www.silver.hom;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WordController {
	ArrayList<WordVO> wlist = new ArrayList<WordVO>();
	
	@RequestMapping(value = "word", method = RequestMethod.GET)
	public String word() {
		return "word/word";
	}
	
	@RequestMapping(value = "word", method = RequestMethod.POST)
	public String myWord_post(@RequestParam("word") String word, @RequestParam("meaning") String meaning) {
		WordVO wvo = new WordVO();
		wvo.setWord(word);
		wvo.setMeaning(meaning);
		wlist.add(wvo);
//		System.out.println(word);
//		System.out.println(meaning);
//		System.out.println(wvo);
//		for (int i=0; i<wlist.size(); i++) {
//			System.out.println(wlist.get(i));
//		}
		return "word/word";
	}
	
	@RequestMapping(value = "wordSearch", method = RequestMethod.GET)
	public String myWord_get(@RequestParam("search") String search, Model model) {
		model.addAttribute("search", search);
		for (int i=0; i<wlist.size(); i++) {
			if (search.equals(wlist.get(i).getWord())) {
//				System.out.println(wlist.get(i));
//				System.out.println(wlist.get(i).getWord());
//				System.out.println(wlist.get(i).getMeaning());
				model.addAttribute("word", wlist.get(i).getWord());
				model.addAttribute("meaning", wlist.get(i).getMeaning());
				break;
			}
		}
		return "word/wordSearch";
	}
	
}
