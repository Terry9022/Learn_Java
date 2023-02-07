
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k<message.length();k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] +=1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k =0;k<vals.length;k++){
            if(vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String input = fr.asString();
        CaesarCipher cc = new CaesarCipher(18); 
        String encrypt = cc.encrypt(input);
        String decrypt = cc.decrypt(encrypt);
        
        System.out.println(encrypt);
        System.out.println(decrypt);
        
        breakCaesarCipher(encrypt);
    }
    
   
    
    public void breakCaesarCipher(String input){
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4 ){
            dkey = 26 - (4-maxDex);
        }
        System.out.println("breaker");
        System.out.println(dkey);
        CaesarCipher cc = new CaesarCipher(dkey);
        System.out.println(cc.decrypt(input));
    }
}
