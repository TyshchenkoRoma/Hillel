import java.util.*;

/**
 * Created by roman on 06.06.16.
 */
public class LinesApp {
    private static final String SPACE = " ";
    private static final char DELIMITER = 'a' | 'e' | 'i' | 'o' | 'u' | 'y';


    public static void main(String[] args) {
        String strings[] = {"Roma","ROMA", "roma", "Valentina", "aeiou", "Sam", "Sam", "Li San", "Roma", "Valentina Va Va", "R O M A"};
        System.out.println(Arrays.toString(strings));

        List<String> list = new ArrayList<>(strings.length);
        List<String> listUperCase = new ArrayList<>(strings.length);

        Map <String, Integer> map = new HashMap<>();
        for (String s : strings) {
            Integer text = map.get(s);
            if (text == null ) {
                map.put(s, 1);
            }else {
                map.put(s,text+1);
            }
            list.add(s);
            listUperCase.add(s.toUpperCase());
        }
        System.out.println(map);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = map.get(o1) - map.get(o2);
                if (res != 0)
                return res;
                else {
                    return o1.compareTo(o2);
                }
            }
        });
        System.out.println("after compering map = "+ list);


        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(list);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return getNumberDelimiters(o1) - getNumberDelimiters(o2);
            }
        });
        System.out.println(list);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return getNumberSpaces(o1) - getNumberSpaces(o2);
            }
        });
        System.out.println(list);

        HashSet<String> set= new HashSet<>(list);
        System.out.println(set);
        set= new HashSet<>(listUperCase);
        System.out.println(set);




    }
    public static int getNumberDelimiters(String st) {
        return st.length() - st.replaceAll("a|e|i|o|u|y","").length();
    }
    public static int getNumberSpaces(String st) {
        return st.length() - st.replaceAll(" ","").length();
    }
}

