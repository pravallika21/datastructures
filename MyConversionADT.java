/* This program is going evaluate expression with & without braces. */

import java.util.Scanner;

class ConversionADT
{
	char stk[];
	int top;
	final int MAX = 10;

	public ConversionADT()
	{
		stk= new char[MAX];
		top = 0;
	}

	public String infixToPostfix(String infix)
	{
		String postfix=" ";
		char ch;
		
		for(int i=0;i<infix.length();i++)
		{
			ch = infix.charAt(i); // taking one char at a time from infix
			if(Character.isLetter(ch))
				postfix += ch;
			else
			if(ch=='(')
				stk[++top] = ch;
			else
			if(ch == ')')
			{
				while(stk[top]!='(') // pop all operators from stack & place in postfix
					postfix += stk[top--];
				top--; // cancel the '(' too
			}
			else // if is operator, check the priority
			{
				while( priority(stk[top]) >= priority(ch) )					
					postfix += stk[top--];
				stk[++top] = ch;
			}			
		}
		while(top>0)	// pop all remaining operators from stack & place them in the postfix
			postfix += stk[top--];				

		return postfix;
	}

	public int priority(char ch) // supporting function for conversion
	{
		if(ch=='^')  	// assume that '^' indicates power (Ex.a^b)
			return 5;
		else
		if((ch=='*') || (ch=='/') || (ch=='%'))
			return 4;
		else
		if((ch=='+') || (ch=='-'))
			return 3;
		else
		if(ch=='=')		
			return 1;
		else
			return -1;
	}
}

public class MyConversionADT
{
	public static void main(String args[])
	{
		String infix,postfix;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any infix notation...");
		infix = sc.next(); // input as string
	
		ConversionADT c = new ConversionADT();

		postfix = c.infixToPostfix(infix);	

		System.out.println("The given infix notation..."+infix);
		System.out.println("The given Postfix notation..."+postfix);
	}
}