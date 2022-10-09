import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Stack; //First in last out
import java.util.LinkedList; // First in first out

import Funktion;
public class Parser{
    public Parser(){

    }
    //teilt den eingegebenen String in einzelne Fragmente auf 
    //und gibt sie dann alle als ein Objekt des Typs Funktion zurück                                   
    public Function stringZuFunktion(String input){
        String in = transformString(input);
        
        
        ArrayList<String> monome = new ArrayList<String>();

        


        return null;
    }

    public void breakDown(String input){
        String REGEX = "\\(([^()]*)\\)";
        Pattern p = Pattern.compile(REGEX);

        Matcher m = p.matcher(input);
        
        if (m.find( )) {
            System.out.println(m.group());
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
         }else {
            System.out.println("NO MATCH");
         };
               
    }
    // parsing arithmetical or logical expressions
    public String shuntingYardAlgo(String expression){
        Stack<Character> stack = new Stack<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        char[] symbols = expression.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            switch(symbols[i]){
                case '+':
                    stack.add(symbols[i]);
                    break;
                case '-':
                    stack.add(symbols[i]);
                    break;
                case '*':
                    stack.add(symbols[i]);
                    break;
                case '/':
                    stack.add(symbols[i]);
                    break;
                case '^':
                    stack.add(symbols[i]);
                    break;
                case '(':
                    stack.add(symbols[i]);
                    break;
                case ')':
                    stack.add(symbols[i]);
                    break;
                case 'S':
                    stack.add(symbols[i]);
                    break;
                case 'C':
                    stack.add(symbols[i]);
                    break;
                default:
                    
            }    
        }

    }

    private Function latexToFunction(String input){ //wandelt eins der String Fragmente in Funktion um
        if(isOperationInFunctionString(input, "/sqrt")){//sqrt
            double m =Double.parseDouble(input.substring(input.indexOf("[")+1, input.indexOf("]")));
            double n =Double.parseDouble(input.substring(input.indexOf("{")+1, input.indexOf("}")));
            return new Monome(n/m, 1);
        }
        if(isOperationInFunctionString(input, "/frac")){ //fraction

        }
        if(isOperationInFunctionString(input, "^")){ //expo.
            double exp =Double.parseDouble(input.substring(input.indexOf("^")+1, input.indexOf("^")+2));
            double c =Double.parseDouble(input.substring(input.indexOf("^")-1, input.indexOf("^")));
            return new Monome(exp, c);
        }
        if(isOperationInFunctionString(input, "/sin")){ //sin
            double c = 0;
            try{
                c =Double.parseDouble(input.substring(input.indexOf("/")-1, input.indexOf("/")));
            }catch(NullPointerException e){
                c = 1;
            }
            return new Sinus(c);
        }
        return null;
    }
    //checks if operation is in funktion string
    public boolean isOperationInFunctionString(String strOfFunktion, String strOfOperation){
        if(strOfFunktion.contains(strOfOperation))return true;
        else return false;
    }

    public String transformString(String in){ //clean the input string
        String output = in;
        output = output.strip();
        return output;
    }

}