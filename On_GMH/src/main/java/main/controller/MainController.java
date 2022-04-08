package main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import accounts.model.ACDao;
import courses.model.COSDao;

public class MainController {
	
	private final String command="/main.ac";
	private String getPage="main";
	
	@Autowired
	private ACDao acdao;
	private COSDao cosdao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value=)
			
}
