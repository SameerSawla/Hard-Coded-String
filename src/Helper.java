import java.util.ArrayList;
import java.util.Iterator;


public class Helper {

	public static Files getFileObject(ArrayList<Files> fileArray,String searchMe)
	{
		for(Files tempFile : fileArray)
		{
			if(tempFile.getFileName().equals(searchMe))
			{
				return tempFile;
			}
		}
		return null;
	}
	
	public static lineInfo getLineInfoObject(ArrayList<lineInfo> lineInfoArray,String searchMe)
	{
		for(lineInfo tempLineInfoObject : lineInfoArray)
		{
			if(tempLineInfoObject.getLineNos().equals(searchMe))
			{
				return tempLineInfoObject;
			}
		}
		return null;
	}
	
	
	public static Files getTheLastFile(ArrayList<Files> fileArray)
	{
		Iterator it = fileArray.iterator();
		Files tempFile = (Files)it.next();
		while(it.hasNext())
		{
			tempFile = (Files)it.next();
		}
		return tempFile;
	}
	
	
}
