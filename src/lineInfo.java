import java.util.ArrayList;


public class lineInfo {
	
	private String lineNos;
	private ArrayList<Data> datas;
	public String getLineNos() {
		return lineNos;
	}
	public void setLineNos(String lineNos) {
		this.lineNos = lineNos;
	}
	public ArrayList<Data> getDatas() {
		return datas;
	}
	public void setDatas(ArrayList<Data> datas) {
		this.datas = datas;
	}
	
	public lineInfo(String lineNos)
	{
		this.lineNos = lineNos;
		datas = new ArrayList<Data>();
	}
	
	public String toString()
	{
		return lineNos;
	}
	
	
}
