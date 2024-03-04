package week2.day2;

public class Palindrome {

public static void main(String arg[])	
		{
		    int t,s,rem;
		    int num = 12345;
		    t=num;
		    for(s=0;num>0;num/=10)
		    {
		    rem=num%10;
		    s=(s*10)+rem;
		    }
		   if(s==t)
			System.out.println(t+" is a palindrome number ");
	        else
			System.out.println(t+" is not a palindrome number ");
	                  
		}
	}