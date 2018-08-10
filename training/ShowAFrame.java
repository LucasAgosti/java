import javax.swing.JFrame;

class ShowAFrame{
	public static void main(String[] args){
		
		JFrame myFrame = new JFrame();
		String title = "Blank frame";
		
		myFrame.setTitle(title);
		myFrame.setSize(800, 300);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	
	}
}
