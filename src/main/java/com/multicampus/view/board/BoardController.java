package com.multicampus.view.board;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.multicampus.biz.board.BoardListVO;
import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Resource(name="xmlView")
	private View xmlView;
	
	@Resource(name="jsonView")
	private View jsonView;
	
	// 데이터 변환
	@RequestMapping("dataTransform.do") 
	public ModelAndView dataTransform(@RequestParam("format") String format) {
		BoardVO vo = new BoardVO();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO listVO = new BoardListVO(boardList);
		ModelAndView mav = new ModelAndView();
		mav.addObject(listVO); // Model 저장
		if(format.equals("xml")) mav.setView(xmlView);// View 저장
		if(format.equals("json")) mav.setView(jsonView);
		return mav;
	}
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BindingResult errors) throws IOException {
		// 유효성 체크
		new BoardValidator().validate(vo, errors);
		if(errors.hasErrors()) return "insertBoard.jsp";
		
		// 파일 업로드
		MultipartFile uploadFile = vo.getUploadFile();
		if(uploadFile.getOriginalFilename().length() > 0) {
			String file = uploadFile.getOriginalFilename();
			byte[] data = uploadFile.getBytes();
			FileOutputStream out = new FileOutputStream("C:/" + file);
			out.write(data);
			out.close();
		}
		
		// 글 등록 처리
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, ModelMap model) {		
		model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장
		return "getBoard.jsp";   // View 이름 리턴
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보 저장
		return "getBoardList.jsp";   // View 이름 리턴
	}
}








