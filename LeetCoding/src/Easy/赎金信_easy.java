package Easy;

/**
 * @author czj
 * @date   2019-06-24 09:41
 */
public class 赎金信_easy {
	public static void main(String[] args) {

	}
	public boolean canConstruct(String a, String b) {
        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();
        int[] inta = new int[26];
        int[] intb = new int[26];
        for(char c:cha){
            inta[c-'a']++;
        }
        for(char c:chb){
            intb[c-'a']++;
        }
        for(int i=0; i<26; i++){
            if(intb[i] < inta[i])
                return false;
        }
        return true;
    }
}
