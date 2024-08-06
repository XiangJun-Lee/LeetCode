import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class WeeklyContest189 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int res = 0;
        for(int i=0;i<len;i++){
            if(queryTime>=startTime[i]&&queryTime<=endTime[i])
                res++;
        }
        return res;
    }

    public String arrangeWords(String text) {
        HashMap<Integer, ArrayList<String>> wordsLen = new HashMap<>();
        String[] words = text.split(" ");
        for(String word :words){
            int len = word.length();
            if(wordsLen.containsKey(len)){
                ArrayList<String> w =  wordsLen.get(len);
                w.add(word.toLowerCase());
                wordsLen.put(len,w);
            }else {
                ArrayList<String> w =  new ArrayList<>();
                w.add(word.toLowerCase());
                wordsLen.put(len,w);
            }
        }
        ArrayList<Integer> keys = new ArrayList<>(wordsLen.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        int len = keys.size();
        for(int i=0;i<len;i++){
            ArrayList<String> w =  wordsLen.get(keys.get(i));
            int wLen = w.size();
            for(int j=0;j<wLen;j++){
                String word = w.get(j);
                if(i==0&&j==0){
                    sb.append(word.substring(0,1).toUpperCase()+word.substring(1));
                    sb.append(" ");
                    continue;
                }
                if(i==len-1&&j==wLen-1){
                    sb.append(word);
                    continue;
                }
                sb.append(word);
                sb.append(" ");

            }
        }
        return sb.toString();
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int len = favoriteCompanies.size();
        List<Integer> res = new ArrayList<>();
        loop1:for(int i=0;i<len;i++){
            List<String> preIndex = favoriteCompanies.get(i);
            int containSize = 0;
            for(int j=0;j<len;j++){
                List<String> nextIndex = favoriteCompanies.get(j);
                if(nextIndex.size()>preIndex.size()&&nextIndex.containsAll(preIndex)){
                    continue loop1;
                }
            }
            res.add(i);
        }
        return res;
    }

//    public int numPoints(int[][] points, int r) {
//
//    }

    @Test
    public void busyStudentTest(){

    }

    @Test
    public void arrangeWordsTest(){
        String text = "Keep calm and code on";
        System.out.println(arrangeWords(text));
    }

    @Test
    public void peopleIndexesTest(){
        List<List<String>> favoriteCompanies = new ArrayList<>();
        String[][] words = {{"leetcode","google","facebook"},{"google","microsoft"},{"google","facebook"},{"google"},{"amazon"}};
        for(String[] word : words){
            List<String> index = new ArrayList<>();
            index.addAll(Arrays.asList(word));
            favoriteCompanies.add(index);
        }
        System.out.println();
        System.out.println(peopleIndexes(favoriteCompanies));
    }
}
