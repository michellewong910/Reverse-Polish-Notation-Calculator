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
			} catch (NumberFormatException exception) {
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

					int total = operands.pop();
					for (int i = total; i > 1; i--) {
						total = total * (i - 1);

					}

					operands.push(total);
				}

			}

		}
		return operands.pop();
	}
}
