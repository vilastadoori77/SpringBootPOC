package searchfiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import searchfiles.model.FindLargeFiles;




@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestSearchFilesApplicationTests {
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	private FindLargeFiles largeFiles;
	
	private static final Logger log = LoggerFactory.getLogger(FindLargeFilesTest.class);
	
	@Test
	public void getHealthStatus() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/health").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
	}

	@Test
	public void contextLoads() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/test").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("Hello Vilas")));
	}
	
	
	@Test
	public void getAllResults() throws Exception {
		
		String dir = "/home/sumanshreeansh/Desktop";
		String pattern ="This is a great language to learn";
		
		largeFiles.searchDirectory(new File(dir), pattern);
		
		List<String> getResults = largeFiles.getResult();
		
		for(String results : getResults){
			log.info("The Value of the results are" + " : "+ results);
		}
		
		
		mvc.perform(MockMvcRequestBuilders.get("/getallresults").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
		
		
		
		
	}
	
	

	
}


