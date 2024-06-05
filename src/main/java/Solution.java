import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] freq = new int[26];
        for(int i = 0; i < words[0].length(); i++) {
            int ch = words[0].charAt(i) - 'a';
            freq[ch]++;
        }
        List<String> result = new ArrayList<>();
        for(int i = 1; i < words.length; i++) {
            int[] curWordFreq = new int[26];
            for(int j = 0; j < words[i].length(); j++) {
                int ch = words[i].charAt(j) - 'a';
                curWordFreq[ch]++;
            }
            for(int j = 0; j < 26; j++){
                freq[j] = Math.min(freq[j], curWordFreq[j]);
            }
        }
        for(int j = 0; j < 26; j++){
            if(freq[j] != 0) {
                while(freq[j]-- > 0){
                    result.add("" + (char)('a' + j));
                }  
            }
        }
        return result;
    }
}