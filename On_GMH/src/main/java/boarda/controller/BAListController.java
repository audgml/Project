package boarda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boarda.model.BABean;
import boarda.model.BADao;
import utility.Paging;

@Controller
public class BAListController {
	
	private final String command = "/list.ba";
	private String getPage = "list";
	
	@Autowired
	private BADao badao;

	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			HttpServletRequest request) {
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount=badao.totalCount(map);
		System.out.println("totalCount:"+totalCount);
		
		String url=request.getContextPath()+command;
		Paging pageInfo=new Paging(pageNumber, null, totalCount, url, null, keyword);
		
		  
		List<BABean> list = badao.getBAList(pageInfo, map);
	 
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("totalCount",totalCount);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(getPage);
		return mav;
	
	}

	
}
