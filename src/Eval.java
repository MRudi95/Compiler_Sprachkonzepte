import lexer.*;
import node.*;
import parser.*;
import analysis.*;
import java.io.*;
import java.util.Stack;

public class Eval extends DepthFirstAdapter {

    protected String value;
    protected String symbol = "";
    protected StringBuilder expvalue = new StringBuilder();
    protected Stack<String> symbols = new Stack<>();


    public String  getExpValue() { return expvalue.toString(); }


    public void outAAddOp(AAddOp node) {
        symbols.push(symbol);
        expvalue.append("(");
        symbol = "+";
    }

    public void outASubOp(ASubOp node) {
        symbols.push(symbol);
        expvalue.append("(");
        symbol = "-";
    }

    public void outAMulOp(AMulOp node) {
        symbols.push(symbol);
        expvalue.append("(");
        symbol = "*";
    }

    public void outADivOp(ADivOp node) {
        symbols.push(symbol);
        expvalue.append("(");
        symbol = "/";
    }

    public void outAKlam(AKlam node) {
        expvalue.replace(expvalue.lastIndexOf(symbol)-1, expvalue.length(), ") ");
        symbol = symbols.pop();
        expvalue.append(symbol).append(" ");
    }

    public void outANumTerm(ANumTerm node) {
        expvalue.append(value).append(" ").append(symbol).append(" ");
    }

    public void caseTNumber(TNumber n) {
        value = n.getText();
    }


    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Eval <filename>");
            System.exit(1);
        }
        try {

            BufferedReader file = new BufferedReader(new FileReader(args[0]));
            // create lexer
            Lexer lexer = new Lexer(new PushbackReader(new BufferedReader(new FileReader(args[0])), 1024));

            // parser program
            Parser parser = new Parser(lexer);
            Start ast = parser.parse();

            // eval nodes in ast
            Eval c = new Eval();
            ast.apply(c);
            System.out.println("Eingabe: " + file.readLine());
            System.out.println("Ausgabe: " + c.getExpValue());

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}