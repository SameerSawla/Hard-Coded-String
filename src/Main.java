
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main{

	
	
	public static void main(String args[])
	{

		String path = " path of the file ";
		//Name of the file
		String name = " file name with extension ";

		//Helper Variables
		String currentFileName="";
		String currentLineNos="";
		   
		   
		ArrayList<Files> files = new ArrayList<Files>();
		
		
		
		 //Reading from the file		
		 try{
			 
			 BufferedReader in = new BufferedReader(new FileReader(path+name));
			 String line="";
			 while ((line = in.readLine()) != null)
			 	{
				 
				   Pattern patternData = Pattern.compile("cf[0-9](.*?)\\\\cf[0-9]");
				   Pattern patternLine = Pattern.compile("Line_(.*?)_eniL");
				   Pattern patternFile = Pattern.compile("File_(.*?)_eliF");
				   
				   Matcher matchData = patternData.matcher(line);
				   Matcher matchLine = patternLine.matcher(line);
				   Matcher matchFile = patternFile.matcher(line);
				 
				   if(matchFile.find())
				   {
//					   System.out.println("found File");
					   String foundFile = matchFile.group(1);
//					   System.out.println(foundFile);
					   
					   if(Helper.getFileObject(files, foundFile)==null)
					   {
						   Files newFile = new Files(foundFile);
						   files.add(newFile);
					   }
					   currentFileName =  foundFile;
				   }
				   
				   if(matchLine.find())
				   {
//					   System.out.println("found Line");
					   String foundLine = matchLine.group(1);
//					   System.out.println(foundLine);
					   
					   Files lastFile  = Helper.getTheLastFile(files);
					   lastFile.getLines().add(new lineInfo(foundLine));
//					   System.out.println("test");
					   currentLineNos = foundLine;
				   }
				 
				   while(matchData.find())
				   {
//					   System.out.println("found Data");
					   line = line.substring(matchData.end(), line.length()-1);
					   String foundData = matchData.group(1);
//					   System.out.println(foundData);
					   
					   Files currentFile = Helper.getFileObject(files, currentFileName);
					   lineInfo currentLineInfoObject = Helper.getLineInfoObject(currentFile.getLines(), currentLineNos);
					   currentLineInfoObject.getDatas().add(new Data(foundData));
					   
					   matchData = patternData.matcher(line);
				   }
		 		}
			 
			    for(Files file:files)
			    {
			 	System.out.println(file);
			    }
			    in.close();
			 
			    

		 	}
		 catch(Exception e)
		 	{
			 e.printStackTrace();
		 	}
		
	}
	 
	
}
