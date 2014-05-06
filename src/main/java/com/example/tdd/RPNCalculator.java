package com.example.tdd;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RPNCalculator {

	public int solveEquation(final String input) {
		final Stack<Integer> operands = new Stack<Integer>();

		List<String> tokenizedInput = Arrays.asList(input.split(" "));

		for (String currentToken : tokenizedInput) {
			try {
				int inputAsInt = Integer.parseInt(currentToken);
				operands.push(inputAsInt);
				continue; // move to the next iteration of the loop
			} catch (NumberFormatException exception) {
				// do nothing, just continue
			}

			if (currentToken.contains("+")) {
				int total = operands.pop() + operands.pop();
				operands.push(total);
				
			} else if (currentToken.contains("-")) {
				int secondNum = operands.pop();
				int total = operands.pop() - secondNum;
				operands.push(total);
				
			} else if (currentToken.contains("*")) {
				int total = operands.pop() * operands.pop();
				operands.push(total);
				
			} else if (currentToken.contains("/")) {
				int secondNum = operands.pop();
				int total = operands.pop() / secondNum;
				operands.push(total);
				
			} else if (currentToken.contains("!")) {
				
				// for(intitialize loop variable ; loop condition; do after
				// every loop iteration)
				
				int total = factorial(operands.pop());
				
				operands.push(total);
				
			} else if (currentToken.contains("^")){
				
				int exponent = operands.pop();
				int baseNum = operands.pop();
				double total = Math.pow(baseNum,exponent);
				operands.push((int)total);
						
				
			} else if (currentToken.contains("SQRT")){
				
				int number = operands.pop();
				double total = Math.sqrt(number);
				operands.push((int)total);
				
				
			} else if(currentToken.contains("ABS")){
				Integer absNum = operands.pop();
				
				if (absNum<0){
					absNum = absNum*-1;
					
				}
				 operands.push(absNum);
			} else if (currentToken.contains("PI")){
				double roundedPi = Math.PI;
				operands.push((int)roundedPi);
			}

		}
		return operands.pop();
	}

	private int factorial(final Integer operand) {
		/* Recursive Approach to factorial! */
		if( operand<2)
		{
			return 1;	
		}
		return operand * factorial(operand-1);
		
		/* Iterative Approach to factorial! */
//		int total = 1;
//		for (int i = operand ; i > 0; i--) {
//			total = total * i ;
//			
//		}
//		return total;
	}
}
