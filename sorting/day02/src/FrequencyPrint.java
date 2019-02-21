import java.util.*;

public class FrequencyPrint {


    static String frequencyPrint(String s) {
        String[] words = s.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            int num = map.getOrDefault(words[i], 0);
            map.put(words[i], num + 1);
        }
        HashMap<Integer,String> sorted = new HashMap<>();
        for(String key : map.keySet()) {
            String str = "";
            for(int i = 0; i < map.get(key); i++) {
                str += key + " ";
            }
            String val = sorted.getOrDefault(map.get(key),"");
            sorted.put(map.get(key),val+str);
        }
        List<Integer> order = new ArrayList<Integer>(sorted.keySet());
        Collections.sort(order);
        String str = "";
        for(int i = 0; i < order.size(); i++) {
            str += sorted.get(order.get(i));
        }
        return str.substring(0,str.length()-1);
    }

}