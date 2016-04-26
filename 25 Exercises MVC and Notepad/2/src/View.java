import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by roman on 22.04.16.
 */
public class View {
    public static final String MAX_VALUE = " max value = ";
    public static final String MAX_INDEX = " max index = ";

    public void concatenationAndPrint (String ... m) {
        StringBuffer line = new StringBuffer();
        for (String v: m) {
            line.append(v);
        }
        System.out.println(line);
    }
}
