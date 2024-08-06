/**
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 */

/**
 * 解题思路：哈希字典
 * 1.将chars转化为hash字典。例如：book -> b:1 o:2 k:1
 * 2.将words中的每个word转化为hash字典
 * 3.比较word中每个元素与chars中对应元素的数值，若有≥，则匹配失败；若匹配成功，返回值 +word.length()
 */
public class CountCharacters {
    public static int countCharacters(String[] words, String chars) {
        int[] c = changeToInt(chars);
        int result = 0;
        loop:for(String word : words){
            int num =0;
            int[] intWord = changeToInt(word);
            for(int i =0;i<26;i++){
                if(intWord[i]<=c[i]){
                    num+=intWord[i];
                }else {
                    num=0;
                    continue loop;
                }
            }
            result+=num;
        }
        return result;
    }
    private static int[] changeToInt(String word){
        int[] c = new int[26];
        for(char temp : word.toCharArray()){
            c[temp-'a']+=1;
        }
        return c;
    }
    public static void main(String[] args){
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words,chars));
    }
}
