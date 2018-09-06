import java.util.Scanner;
import static java.lang.System.out;

public class UsingLamp{
	public static void main(String[] args){
		
		Lamp light = new Lamp();
		Scanner input = new Scanner(System.in);
		
		out.println("Set the lamp status");
		boolean lampStatus = input.nextBoolean();
		
		light.setStatus(lampStatus);
		out.println(light);
	}
}
