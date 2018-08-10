import javax.swing.JOptionPane;

class FirstLogin{
	public static void main(String[] args){
	
		String username = JOptionPane.showInputDialog("Username:");
		String password = JOptionPane.showInputDialog("Password:");
		
		if(username != null && password != null && ((username.equals("person") && password.equals("123")))){	
			JOptionPane.showMessageDialog(null, "Connected.");
		}else{
			JOptionPane.showMessageDialog(null, "Wrong username or password.");
		}
	}
}
