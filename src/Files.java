
import java.io.StringWriter;
import java.util.ArrayList;


public class Files {

	private String fileName;
	private ArrayList<lineInfo> lines;
	
	public Files(String fileName)
	{
	 this.fileName = fileName;
	 lines = new ArrayList<lineInfo>();
	 
	}
	
	public String getFileName(){
	
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public ArrayList<lineInfo> getLines() {
		return lines;
	}



	public void setLines(ArrayList<lineInfo> lines) {
		this.lines = lines;
	}

	public String toString()
	{
		
		StringWriter string = new StringWriter(); 
		string.append("\nFile Name : "+ fileName + "\n\n"+"\t\tLine Numbers\t\t\t\t\t\tHard Coded Text\n\t\t------------\t\t\t\t\t\t---------------");
		for(lineInfo tempLineInfo : lines)
		{
			string.append("\n\t\t   "+tempLineInfo.getLineNos());
			int count=1;
			for(Data tempData : tempLineInfo.getDatas())
			{
				string.append("\n\t\t\t\t\t\t\t\t\t"+count+". "+tempData.getData());
				count++;
			}
		}
		return string.toString();
		
	}
	//not needed as of now 
	public void putLineInfoObject(String lineNo)
	{
		
		lineInfo tempLineObject2 = null;
		for(lineInfo tempLineObject :  this.lines)
		{	
			if(tempLineObject.getLineNos().equals(lineNo))
			{
				tempLineObject2 = tempLineObject;
				break;
			}
			}
		
		if(tempLineObject2!=null)
		{
			this.lines.add(tempLineObject2);
		}
		
		
	}
	
}
