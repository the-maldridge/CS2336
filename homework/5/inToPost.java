import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class inToPost {
    public static void main(String[] args) {
	eqMan foo = new eqMan();
	Queue<QType> infix = foo.tokenize("  23/4 +(7 ^7)*B+1");
	System.out.println(infix);
	System.out.println(foo.shunt(infix));
	
    }
}

class eqMan {
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
		System.out.println("got op");
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
	
	System.out.println(eq);
	
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