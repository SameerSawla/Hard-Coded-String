import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class jsonCreationHelper {

	
	public static ArrayList<String> jsonInput = new ArrayList<String>();
	public static int counter = 0;
	
	
	public static void createJsonFile() throws IOException
	{
		
		File file = new File("ouptput_.json");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Total number of conversions : " + jsonCreationHelper.counter);
		bw.write("\n\n{\n");
		for (String tempData : jsonCreationHelper.jsonInput) {
			bw.write("\""+ tempData + "\"" + "  :  " + "\"" +  tempData + "\"" + ",\n");
		}
		bw.write("}");

		bw.close();
		
	}
	
}
