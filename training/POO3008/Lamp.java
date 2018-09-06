public class Lamp{

	private boolean status;
	
	public void setStatus(boolean status){
		this.status = status;
	}
	public boolean getStatus(){
		return status;
	}
	
	public String toString(){
		String str = "";
		str = str + "*----------------*\n";
		str = str + "Lamp status:\n";
		str = str + "On: " + this.status + "\n";
		str = str + "*----------------*\n";
		return str;
	}
}
