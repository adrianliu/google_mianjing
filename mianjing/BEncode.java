package google.mianjing;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaopengliu on 11/04/16.
 */
public class BEncode {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("extrodinary_smart");
        list.add("adrian");
        list.add("2345");

        String encoded = encode(list);
        System.out.println("Encoded list is: " + encoded);

        System.out.println("decoded string is: ");
        printList(decode(encoded));


    }

    private static String encodeString(String s) {
        return s.length() + ":" + s;
    }

    private static void printList(List<String> list) {
        for(String s: list) {
            System.out.print(s + " ");
        }
    }

    public static String encode(List<String> strings) {
        String encodedStr = "l";
        for(String s: strings) {
            encodedStr += encodeString(s);
        }
        encodedStr += "e";
        return encodedStr;
    }

    public static List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int i = 1;
        while(i < s.length() - 1) {
            int len = 0;
            while(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                len = 10*len + (s.charAt(i) - '0');
                i++;
            }
            if(s.charAt(i) == ':') {
                String aWord = "";
                i++;
                for(int j = i;j < i + len;j++) {
                    aWord += s.charAt(j);
                }
                i = i + len;
                list.add(aWord);
            } else {
                System.out.println("Wrong format");
            }

        }
        return list;
    }
}
