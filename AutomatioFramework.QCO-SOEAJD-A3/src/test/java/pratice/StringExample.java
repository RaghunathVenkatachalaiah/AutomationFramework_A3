package pratice;
import java.util.Scanner;

public class StringExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String s=sc.nextLine();
		int count=0;
		for(int i=0; i<s.length();i++)
		{
			if(s.charAt(i)==0)
			{
				count++;
			}
		}
		if(count>0)
		{
			System.out.println("specific charecter 'a' is found"+ count + "times");
		}
		else
		{
			System.out.println("specific charecter 'a' not found");
		}
	}

}


