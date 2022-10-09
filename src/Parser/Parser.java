package Parser;
import java.util.ArrayList;

import Funktion;
public class Parser{
    public Parser(){

    }
    //teilt den eingegebenen String in einzelne Fragmente auf 
    //und gibt sie dann alle als ein Objekt des Typs Funktion zurück                                   
    public Funktion stringZuFunktion(String input){
        String in = transformString(input);
        ArrayList<String> monome = new ArrayList<String>();

        


        return null;
    }
    private Funktion latexZuFunktion(){ //wandelt eins der String Fragmente in Funktion

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