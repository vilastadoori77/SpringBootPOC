package searchfiles;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import searchfiles.model.FindLargeFiles;

public class FindLargeFilesTest {
	
	FindLargeFiles largeFiles = new FindLargeFiles();
	private static final Logger log = LoggerFactory.getLogger(FindLargeFilesTest.class);

	@Test
	public void fileSearchTest() {
		//fail("Not yet implemented");
		
		String dir = "/home/sumanshreeansh/Desktop/filepattern";
		String pattern ="This is a great language to learn";
		int expected = 2;
		
		largeFiles.searchDirectory(new File(dir), pattern);
		
		int actual = largeFiles.getResult().size();
		
		log.info("The actual no of files are"+":"+ actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void allFileSearchTest(){
		
		String dir = "/home/sumanshreeansh/Desktop";
		String pattern = "This is a great language to learn";
		int expected = 4;
		
		largeFiles.searchDirectory(new File(dir), pattern);
		
		int actual = largeFiles.getResult().size();
		
		log.info("The actual no of files are"+":"+ actual);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void patternEqual(){
		
		String dir = "/home/sumanshreeansh/Desktop/filepattern";
		String pattern = "This is a great language to learn";
		largeFiles.searchDirectory(new File(dir), pattern);

		
		List<String> patternList = new ArrayList<String>();
		
		patternList = largeFiles.getResult();
		
		

		assertEquals(patternList.size(), largeFiles.getResult().size());
		
		
		
	}
	
	
	

}
