package com.multicampus.view.board;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.multicampus.biz.board.BoardVO;

public class BoardValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return true;
	}

	public void validate(Object target, Errors errors) {
		BoardVO board = (BoardVO) target;
		
		if(board.getTitle() == null || board.getTitle().length() == 0) {
			errors.rejectValue("title", "error.board.title");
		}
		
		if(board.getWriter() == null || board.getWriter().length() == 0) {
			errors.rejectValue("writer", "error.board.writer");
		}
		
		if(board.getContent().length() < 10) {
			errors.rejectValue("content", "error.board.content");
		}
	}

}











