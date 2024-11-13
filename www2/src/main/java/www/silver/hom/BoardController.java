package www.silver.hom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping(value = "board")
	public String board() {
		return "board/board";
	}
	
	@GetMapping(value = "board_write")
	public String board_write() {
		return "board/board_write";
	}
}
