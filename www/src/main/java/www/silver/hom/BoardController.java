package www.silver.hom;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.silver.service.IF_BoardService;
import www.silver.vo.BoardVO;

@Controller
public class BoardController {
	
	@Inject
	IF_BoardService boardservice;
	
	@GetMapping(value = "board")
	public String board(Model model) throws Exception {
		// Controller > Service > DAO > Mapper
		// 전체 게시글을 가져오는 작업이 필요하다.
		List<BoardVO> list = boardservice.boardList();		// 서비스 레이어에 전체글 서비스를 요청하고 결과를 리턴
		System.out.println(list.size() + "건의 게시글");
		model.addAttribute("list", list);	// 리턴받은 list변수의 값을 Model객체로 view에게 전송
		return "board/bbs";					// view 지정
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
//		return "board/bbs";
		return "redirect:board";		// 글 작성 후에도 작성한 게시글이 보여질 수 있도록 redirect 설정
	}
	
	@GetMapping(value = "del")
	public String board_del(@RequestParam("delno") String delno) throws Exception {
		boardservice.deleteBoard(delno);
		return "redirect:board";
	}
}
