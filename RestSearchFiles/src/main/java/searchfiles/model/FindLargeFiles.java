package searchfiles.model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.github.fge.largetext.LargeText;
import com.github.fge.largetext.LargeTextFactory;



@Component //to be managed by spring
public class FindLargeFiles {
	
	private String patternToSearch;
	private List<String> result = new ArrayList<String>();
	private static final Logger log = LoggerFactory.getLogger(FindLargeFiles.class);
	final LargeTextFactory factory = LargeTextFactory.defaultFactory();
	

	public String getpatternToSearch() 
	{
		return patternToSearch;
	}


	public void setpatternToSearch(String patternToSearch) 
	{		
		log.info("Pattern to search is set as " + patternToSearch);
		this.patternToSearch = patternToSearch;
	}
	
	public List<String> getResult()
	{
		return result;
	}
	
	
	public void searchDirectory(File directory, String patternToSearch) 
	{

		
		log.info("Pattern To Search in the searchDirectory() " + patternToSearch);
		setpatternToSearch(patternToSearch);

		if (directory.isDirectory()) 
		{
		    search(directory);
		} 
		else 
		{
		    
		    
		    log.info(directory.getAbsoluteFile() + " is not a directory!");
		}

	}
	
	
	private void search(File file) {
		
		String patternSearch = getpatternToSearch();

		if (file.isDirectory()) {
		  
		  log.info("Searching directory ... " + file.getAbsoluteFile());

	            //do you have permission to read this directory?
		  
		    if (file.canRead()) 
		    {
		    	
		    	//Pattern p = Pattern.compile(patternSearch);
		    	
		    	for (File temp : file.listFiles()) 
		    	{
		    		Path bigTestTextFile = Paths.get(temp.getAbsolutePath());
					log.info("\n");
		    		
		    		log.info(" List of Files " + temp + " \n");
		    		
		    		if (temp.isDirectory())
		    		{
		    			search(temp);
		    		}
		    		else 
		    		{
		    			try(LargeText largetestText = factory.fromPath(bigTestTextFile);)				
		    			{
		    				Pattern PATTERN = Pattern.compile(patternSearch);	 
			
		    				Matcher m = PATTERN.matcher(largetestText);
			 
		    				if(m.find())
		    				{
		    					result.add("Found File Name"+"---"+temp.getName()+" "+"Path"+"----"+temp.getAbsolutePath() );
		    				}
				
		    			}
					    catch(Exception e)
					    {
					      log.info("\n Error processing file : "+temp.getName());
					    }
		    		}
		    	}		    		
		    }
		    else		    	
		    {
		    	log.info(file.getAbsoluteFile() + "Permission Denied");
		     }	      
		}
	}
}