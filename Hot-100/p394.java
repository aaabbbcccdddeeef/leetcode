import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p394 {
    public static void main(String[] args) {
        String str = "3[a2[c]]";
        Matcher matcher;
        matcher = Pattern.compile("\\d+\\[[a-z]+\\]").matcher(str);
        matcher.find();
        System.out.println(decodeString(str));
    }

    public static String decodeString(String s) {
        Matcher matcher;
        matcher = Pattern.compile("\\d+\\[[a-z]+\\]").matcher(s);
        while (matcher.find()) {
            String str = matcher.group();
            matcher = Pattern.compile("\\d+").matcher(str);
            if (!matcher.find()) {
                return s;
            }
            int startIndex = s.indexOf(str), endIndex = str.length() + startIndex;
            int count = Integer.valueOf(matcher.group());
            matcher = Pattern.compile("[a-z]+").matcher(str);
            if (matcher.find()) {
                String inStr = matcher.group();
                StringBuilder sb = new StringBuilder(count * inStr.length());
                for (int i = 0; i < count; i++) {
                    sb.append(inStr);
                }
                str = sb.toString();
            } else {
                str = "";
            }
            s = s.substring(0, startIndex) + str + s.substring(endIndex);
            matcher = Pattern.compile("\\d+\\[[a-z]+\\]").matcher(s);
        }
        return s;
    }
}