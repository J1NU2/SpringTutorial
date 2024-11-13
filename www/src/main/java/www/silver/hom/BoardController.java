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
import www.silver.vo.PageVO;

@Controller
public class BoardController {
	
	@Inject
	IF_BoardService boardservice;
	
	@GetMapping(value = "board")
	public String board(@ModelAttribute PageVO pagevo, Model model) throws Exception {
		// Controller > Service > DAO > Mapper
		
		// 페이징
		if (pagevo.getPage() == null) pagevo.setPage(1);	// 컨트롤러가 view를 처음으로 불러온 경우
		// 3가지 정보
		// 1. 현재 페이지 정보
		// 2. 한 페이지 당 글의 수
		pagevo.setTotalCount(boardservice.totalCountBoard());		// 3. 전체 글의 수
		// 확인용
//		System.out.println("시작 글 번호 : " + pagevo.getStartNo());
//		System.out.println("마지막 글 번호 : " + pagevo.getEndNo());
//		System.out.println("페이지 시작 번호 : " + pagevo.getStartPage());
//		System.out.println("페이지 마지막 번호 : " + pagevo.getEndPage());
		
		// 전체 게시글을 가져오는 작업이 필요하다.
		List<BoardVO> list = boardservice.boardList(pagevo);	// 서비스 레이어에 전체글 서비스를 요청하고 결과를 리턴
//		System.out.println(list.size() + "건의 게시글");
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
	
	@GetMapping(value = "mod")
	public String board_mod(@RequestParam("modno") String modno, Model model) throws Exception {
		BoardVO bvo = boardservice.modBoard(modno);
		// sysout은 서버 입장에서 부하가 걸리는 작업이다.
		// 그렇기 때문에 테스트 수행 후에는 삭제하거나 주석 처리를 하는 것이 좋다.
		// 실제로 sysout은 잘 사용하지 않는다.
		// 테스트 시에는 보통 junit test라는 도구를 사용한다.
		// 또는 기록을 남기기 위해서는 로그라는 기능을 사용한다.
		// 로그는 홈 컨트롤러에 가면 볼 수 있다.
//		System.out.println(bvo.getTitle());
		model.addAttribute("boardvo", bvo);
		return "board/modform";
	}
	
	@PostMapping(value = "mod")
	public String board_mod(@ModelAttribute BoardVO boardvo) throws Exception {
//		System.out.println(boardvo.getTitle());
		boardservice.modBoard(boardvo);
		return "redirect:board";
	}
}
