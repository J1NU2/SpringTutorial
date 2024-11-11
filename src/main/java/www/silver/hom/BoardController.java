package www.silver.hom;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import www.silver.service.IF_BoardService;
import www.silver.vo.BoardVO;

@Controller
public class BoardController {
	
	@Inject
	IF_BoardService boardservice;
	
	@GetMapping(value = "board")
	public String board() throws Exception {
		// Controller > Service > DAO > Mapper
		// 전체 게시글을 가져오는 작업이 필요하다.
		
		return "board/bbs";
	}
	
	@GetMapping(value = "board_w")
	public String board_write() throws Exception {
		
		return "board/b_write";
	}
	
	@PostMapping(value = "bw_save")
	public String board_save(@ModelAttribute BoardVO boardvo) throws Exception {
//		System.out.println(boardvo.toString());
		
		// 서비스 레이어에서 작업하기 위해 BoardVO객체를 넘겨준다.
		boardservice.addBoard(boardvo);
		return "board/bbs";
	}
}
