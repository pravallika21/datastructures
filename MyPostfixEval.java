/* Evaluatio of postfix expression */

import java.util.Scanner;
class EvaluateExpression
{
	double stk[];
	int top;
	final int MAX = 10;
	Scanner obj;
	public EvaluateExpression()
	{
		stk = new double[MAX];
		top = 0;
		obj = new Scanner(System.in);
	}
	
	public double operation(double p, double q, char op)
	{
		switch(op)
		{
		  case '^':	return Math.pow(p,q);
		  case '*':	return p*q;
		  case '/':	return p/q;
		  case '+':	return p+q;
		  case '-':	return p-q;
		  case '%':	return p%q;
		}
		return 0;
	}
	
	public double evalPostfix(String post)
	{
		double x,y,z;
		char ch;
		for(int i=0;i<post.length();i++)
		{
			ch = post.charAt(i);// accepting each letter from postfix
			if(Character.isDigit(ch))
				stk[++top] = (double)(ch - '0');//Ex:'5'-'0' ==> 53-48=5 
			else
			if(Character.isLetter(ch))
			{
				System.out.println("Enter value for "+ch+" : ");
				int val = obj.nextInt();
				stk[++top] = val;
			}
			else
			{
				y = stk[top--];
				x = stk[top--];
				z = operation(x,y,ch);
				stk[++top]= z;
			}
		}

		return stk[top]; // final result
	}
}

public class MyPostfixEval
{
	public static void main(String args[])
	{
		EvaluateExpression e = new EvaluateExpression();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any postfix expression...");
		String post = sc.next();
		
		double result = e.evalPostfix(post);
		
		System.out.println("The Result = "+result);
	}
}
