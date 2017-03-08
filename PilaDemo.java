
import java.util.Stack;
import javax.swing.JOptionPane;

public class PilaDemo {

    protected String equation;
    protected String[] equationArray;
    protected final Stack<String> stackIn = new Stack<>();
    protected final Stack<String> stackOut = new Stack<>();
    protected final Stack<String> stackTemp = new Stack<>();

    void setInfix(String equation) {
        this.equation = equation;
        for (int i = 0; i < equation.length(); i++) {
            stackTemp.push(equation.charAt(i) + "");
        }
        JOptionPane.showMessageDialog(null, "La pila infija es: " + stackTemp);
    }

    void postFix(String equation) {
        stackTemp.clear();
        this.equation = equation;
        equation = cleanString(equation);
        String[] infixArray = equation.split(" ");
        for (int i = infixArray.length - 1; i >= 0; i--) {
            stackIn.push(infixArray[i]);
        }
        while (!stackIn.isEmpty()) {
            switch (order(stackIn.peek())) {
                case 1:
                    stackTemp.push(stackIn.pop());
                    break;
                case 2:
                    while (!stackTemp.peek().equals("(")) {
                        stackOut.push(stackTemp.pop());
                    }
                    stackTemp.pop();
                    stackIn.pop();
                    break;
                case 3:
                case 4:
                    while (order(stackTemp.peek()) >= order(stackIn.peek())) {
                        stackOut.push(stackTemp.pop());
                    }
                    stackTemp.push(stackIn.pop());
                    break;
                default:
                    stackOut.push(stackIn.pop());
            }
        }
        JOptionPane.showMessageDialog(null, "Notación infija: "+equation+"\nNotación posfija: " + stackOut.toString().replaceAll("[\\]\\[,]", ""));
    }

    int order(String operator
    ) {
        int order = 0;
        if (operator.equals("^")) {
            order = 5;
        }
        if (operator.equals("*") || operator.equals("/")) {
            order = 4;
        }
        if (operator.equals("+") || operator.equals("-")) {
            order = 3;
        }
        if (operator.equals(")")) {
            order = 2;
        }
        if (operator.equals("(")) {
            order = 1;
        }
        return order;
    }

    String cleanString(String string) {
        string = string.replaceAll("\\s+", ""); //Elimina espacios en blanco
        string = "(" + string + ")";
        String symbols = "+-*/()";
        String newString = "";

        //Deja espacios entre operadores
        for (int i = 0; i < string.length(); i++) {
            if (symbols.contains("" + string.charAt(i))) {
                newString += " " + string.charAt(i) + " ";
            } else {
                newString += string.charAt(i);
            }
        }
        return newString;
    }
}
