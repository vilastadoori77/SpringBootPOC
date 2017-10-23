package searchfiles.controller;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import searchfiles.model.FindLargeFiles;

@RestController
public class SearchFileController {
	

	@Autowired
	FindLargeFiles fsearch;
	
	private static final Logger log = LoggerFactory.getLogger(SearchFileController.class);
	
	
	@GetMapping("/test")
	public String searchTest(){
		return "Hello Vilas";
	}
	
	
	@GetMapping("/searchresults")
	public List<String> searchResults(@RequestParam("dir") String dir,@RequestParam("keyword") String keyword){
	

	String dirpath = dir;
	String kword = keyword;
	
	String comb = dirpath + " : "+kword;
	
	log.info("The entered values are " + comb);
	
	fsearch.searchDirectory(new File(dirpath), kword);
	
	log.info("Size of the Arraylist is  " + fsearch.getResult().size());
	
	return fsearch.getResult();
	}
	
	
	@GetMapping("/getallresults")
	public List<String> getAllResults(){
		return fsearch.getResult();
	}

}
