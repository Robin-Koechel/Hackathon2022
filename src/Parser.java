import java.util.HashMap;
import java.util.Map;
public class Parser{
    private Map<String, String> map = new HashMap<String, String>();
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

    public Function mapToFunction(){
        Function[] functions = new Function[map.size()];
        for (int i = map.size(); i > map.size(); i--) {
            if(map.get(codes[i]).contains("sin")){
                String c = map.get(codes[i]).replaceAll("\\D+","");
                if(c.equals("")){
                    functions[i] = new Sinus(1);
                }else{
                    functions[i] = new Sinus(Integer.parseInt(c));
                }
                
            }
            else if(map.get(codes[i]).contains("cos")){
                String c = map.get(codes[i]).replaceAll("\\D+","");
                if(c.equals("")){
                    functions[i] = new Cosinus(1);
                }else{
                    functions[i] = new Cosinus(Integer.parseInt(c));
                }
            }
            else if(map.get(codes[i]).contains("^")){ //expo
                //noch kein Bock gehabt...
            }
            else{
                functions[i] = new Monome(i, i);
            }

        }
    }
}