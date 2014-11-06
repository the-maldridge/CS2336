/*
Author : Michael Aldridge
Class  : CS2336
Section: 001
Assignment: 5

Instructions: Compile with javac inToPost.java; run as java inToPost; This implementation will make an attempt to calculate all expressions that are calculable.
              Expressions containing variable components will not be calculated.  
	      Multi-digit integer input is accepted.
*/
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class inToPost {
    public static void main(String[] args) {
	Scanner kbd = new Scanner(System.in);
	String infixInput = "";

	System.out.print("Please input a valid infix expression: ");
	infixInput = kbd.nextLine();

	eqMan expressionManager = new eqMan();
	//tokenize the input
	Queue<QType> infix = expressionManager.tokenize(infixInput);
	//shunt through the yard to create postfix
	Queue<QType> postfix = expressionManager.shunt(infix);

	System.out.println("Infix expression: " + infixInput);
	System.out.println("Postfix expression: " + expressionManager.getPostFix(postfix));

	if(expressionManager.hasVar(postfix)) {
	    System.out.println("This expression has variable terms, evaluation not possible.");
	} else {
	    System.out.println("This expression is solvable, answer is: " + expressionManager.calculate(postfix));
	}
    }
}

class eqMan {
    public boolean hasVar(Queue<QType> exp) {
	Queue<QType> temp = new LinkedList<QType>(exp);
	QType current;

	while(!temp.isEmpty()) {
	    current = temp.poll();
	    if(current.type == QType.Type.VARIABLE) {
		return true;
	    }
	}
	return false; //no variables, safe to evaluate
    }

    public String getPostFix(Queue<QType> exp) {
	Queue<QType> rpn = new LinkedList<QType>(exp);
	StringBuilder out = new StringBuilder();

	while(!rpn.isEmpty()) {
	    QType token = rpn.poll();
	    switch(token.type) {
	    case OPERAND:
		out.append(token.value);
		break;
	    case VARIABLE:
		out.append(token.var);
		break;
	    case OPERATOR:
		char c = '|';
		switch(token.op) {
		case ADD:
		    c='+';
		    break;
		case SUB:
		    c='-';
		    break;
		case MUL:
		    c='*';
		    break;
		case DIV:
		    c='/';
		    break;
		case EXP:
		    c='^';
		    break;
		}
		out.append(c);
	    }
	    out.append(" ");
	}
	return out.toString();
    }

    public double calculate(Queue<QType> postfix) {
	Stack<Double> evalStack = new Stack<Double>();
	QType token;
	
	while(!postfix.isEmpty()) {
	    token = postfix.poll();
	    switch(token.type) {
	    case OPERAND:
		evalStack.push((double)(token.value));
		break;
	    case OPERATOR:
		double a,b;
		a = evalStack.pop();
		b = evalStack.pop();
		switch(token.op) {
		case ADD:
		    evalStack.push(a+b);
		    break;
		case SUB:
		    evalStack.push(b-a);
		    break;
		case MUL:
		    evalStack.push(a*b);
		    break;
		case DIV:
		    evalStack.push(b/a);
		    break;
		case EXP:
		    evalStack.push(Math.pow(b,a));
		    break;
		}
	    }
	}

	//if everything has gone right, the answer is on evalStack
	return evalStack.pop();
    }

    public int getOpPriority(QType.OP op) {
	switch(op) {
	case ADD:
	case SUB:
	    return 1;
	case MUL:
	case DIV:
	    return 2;
	case EXP:
	    return 3;
	case LPR:
	case RPR:
	    return 0;
	}
	return -1; //never should make it to here
    }

    public Queue<QType> shunt(Queue<QType> expression) {
	Queue<QType> rpnExpression = new LinkedList<QType>();
	Stack<QType> opStack = new Stack<QType>();

	while(!expression.isEmpty()) {
	    QType currentToken = expression.poll();

	    switch(currentToken.type) {
	    case OPERAND:
		//if it is an operand, add it to the stack
		rpnExpression.add(currentToken);
		break;
	    case VARIABLE:
		//if it is a variable, it is just an operand
		rpnExpression.add(currentToken);
		break;
	    case OPERATOR:
		//if it is an operator, we need to know if it is an lparen
		if(currentToken.op == QType.OP.LPR) {
		    //push the paren on to the opstack and descend
		    opStack.push(currentToken);
		} else if(currentToken.op == QType.OP.RPR) {
		    //if right paren, pop all ops from the stack
		    while(opStack.peek().op != QType.OP.LPR) {
			rpnExpression.add(opStack.pop());
		    }
		    opStack.pop(); //get rid of the lparen sitting on the stack
		} else {
		    while(!opStack.empty() && getOpPriority(currentToken.op) <= getOpPriority(opStack.peek().op)) {
			//if precidence is correct, pop to stack
			rpnExpression.add(opStack.pop());
		    }
		    opStack.push(currentToken);
		}
		break;
	    default:
		System.out.println("EXPRESSION NOT MATHEMATICALLY VALID");
		break;
	    }
	}
	//return any remaining operators
	while(!opStack.isEmpty()) {
	    rpnExpression.add(opStack.pop());
	}

	return rpnExpression;
    }

    public Queue<QType> tokenize(String eq) {
	Queue<QType> tokens = new LinkedList<QType>();
	String operators = "+-*/^()";
	
	//remove all whitespace
	eq = eq.replaceAll("\\s","");
	
	for(int i=0; i<eq.length(); i++) {
	    if(operators.contains(Character.toString(eq.charAt(i)))) {
		//catch operators
		switch(Character.toString(eq.charAt(i))) {
		case "+":
		    tokens.add(toQ(QType.OP.ADD));
		    break;
		case "-":
		    tokens.add(toQ(QType.OP.SUB));
		    break;
		case "*": 
		    tokens.add(toQ(QType.OP.MUL));
		    break;
		case "/":
		    tokens.add(toQ(QType.OP.DIV));
		    break;
		case "^":
		    tokens.add(toQ(QType.OP.EXP));
		    break;
		case "(":
		    tokens.add(toQ(QType.OP.LPR));
		    break;
		case ")":
		    tokens.add(toQ(QType.OP.RPR));
		    break;
		}
	    } else if(Character.isDigit(eq.charAt(i))) {
		int j = i;
		int num = 0;
		while(Character.isDigit(eq.charAt(i))) {
		    //get char, mul by 10
		    num=num*10+Character.getNumericValue(eq.charAt(i));
		    if(i+1<eq.length()) {
			if(Character.isDigit(eq.charAt(i+1))) {
			    i++;
			} else {
			    break;
			}
		    } else {
			break;
		    } 
		}
		tokens.add(toQ(num));
	    } else {
		tokens.add(toQ(eq.charAt(i)));
	    }
	}
	return tokens;
    }

    //convenience functions to build Tokens
    public QType toQ(QType.OP o) {
	QType temp = new QType();
	temp.type = QType.Type.OPERATOR;
	temp.op = o;
	return temp;
    }

    public QType toQ(char v) {
	QType temp = new QType();
	temp.type = QType.Type.VARIABLE;
	temp.var = v;
	return temp;
    }

    public QType toQ(int i) {
	QType temp = new QType();
	temp.type = QType.Type.OPERAND;
	temp.value = i;
	return temp;
    }
}

class QType {
    public enum Type {OPERATOR, OPERAND, VARIABLE};
    public enum OP {ADD, SUB, MUL, DIV, EXP, LPR, RPR};

    public Type type;
    public int value;
    public char var;
    public OP op;

    public String toString() {
	StringBuilder out = new StringBuilder();
	out.append("Type: " + type + " Value: ");
	switch(type) {
	case OPERATOR:
	    out.append(op);
	    break;
	case OPERAND:
	    out.append(value);
	    break;
	case VARIABLE:
	    out.append(var);
	    break;
	}
	return out.toString();
    }
}