import java.util.HashMap;
import java.util.Map;
public class Parser{
    private Map<String, String> map = new HashMap<String, String>();
    private Map<String, Function> functionMap = new HashMap<String, Function>();
    private String[] codes = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
    public Parser(){

    }

    public String stringToFunction(String in){
        String input = in;
        

        int parentheseCount = input.length() - input.replace("(", "").length();;
        char[] inputArray = input.toCharArray();
 
        int counter2 = 0;
        if(parentheseCount > 0){
            for (int i = 0; i < inputArray.length; i++) {
                if(inputArray[i] == '('){
                    counter2++;
                }
                if(counter2 == parentheseCount){
                    String replacement = codes[parentheseCount];
                    String monom = input.substring(i, input.indexOf(')', i)+1);
                    input = input.replace(monom, replacement);
                    map.put(replacement, monom);
                    break;
                }
            }

        
            stringToFunction(input);
        }else{
            map.put(codes[parentheseCount], input);
        }
        return input;
    }
    public Map<String, String> getMap(){
        return map;
    }

    public Function putTogether(){
        for (int i = map.size(); i > map.size(); i--) {
            String line = map.get(codes[i]);
            boolean clean = true;
            for (int j = 0; j < codes.length; j++) {
                if(line.contains(codes[j])){
                    clean = false;
                }
            }
            if(clean){
                functionMap.put(codes[i], mapToFunction(line));
            }
        
        }
    }

    public Function mapToFunction(String l){
        Function result;
        String line = l;
        if(l.contains("S")){
            String c = l.replaceAll("\\D+","");
            if(c.equals("")){
                result = new Sinus(1);
            }else{
                result = new Sinus(Double.parseDouble(c));
            }
            
        }
        else if(line.contains("C")){
            String c = line.replaceAll("\\D+","");
            if(c.equals("")){
                result = new Cosinus(1);
            }else{
                result = new Cosinus(Double.parseDouble(c));
            }
        }
        else{
            
            line = line.replace("(", "");
            line = line.replace(")", "");
            if(line.contains("2.7180")){//expo function
                
                line = line.replace("*x", "");
                double b = Double.parseDouble(line.substring(0,line.indexOf("2.718")));
                double c = Double.parseDouble(line.substring(line.indexOf("^")+1));
                result = new ExponentialFunction(b, c);
            }else{
                double a = Double.parseDouble(line.substring(0,line.indexOf("x")));
                double b = Double.parseDouble(line.substring(line.indexOf("^")+1));
                result = new Monome(a, b);              
            }   
        }
        return result;
    }
}