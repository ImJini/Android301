package com.and.middle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GodataController {
	
	@RequestMapping(value = "select.godata", produces = "text/html;charset=UTF-8")
	public String godate() {
		
		return "일단";
	}
	
//	  ArrayList<GoDTO> list = new Gson().fromJson(data,
//              new TypeToken<ArrayList<GoDTO>>(){}.getType());

}
