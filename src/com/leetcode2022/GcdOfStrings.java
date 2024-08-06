import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 */
public class GcdOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        if(str1.equals("")||str2.equals("")){
            return "";
        }
        if(str1.equals(str2)){
            return str1;
        }
        while(!str1.equals(str2)){
            if(str1.length()==str2.length()&&!str1.equals(str2)){
                return "";
            }
            str1 =maxString(str1,str2.length());
            if(str1.equals("")||str2.equals("")){
                return "";
            }
            if(str1.equals(str2)){
                return str2;
            }
            String temp =str2;
            str2 =str1;
            str1 =temp;
        }
        return "";
    }

    private static String maxString(String str1, int str2Length) {
        if(str1.length()<=1){
            return str1;
        }
        int length = str1.length();
        ArrayList<Integer> count = new ArrayList<>();
        for(int i=2;i<length/2+1;i++){
            if(length%i==0&&str2Length%(length/i)==0){
                String head = str1.substring(0,length/i);
                String end = str1.substring(str1.length()-length/i);
                if(head.equals(end)){
                    return head;
                }
            }
        }
        String head = str1.substring(0,1);
        if(str1.replaceAll(head,"").equals("")){
            return head;
        }
        return "";
    }

    public static void main(String[] args){
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(gcdOfStrings(str1,str2));
    }
}
