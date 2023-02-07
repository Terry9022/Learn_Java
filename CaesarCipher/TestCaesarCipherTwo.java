
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
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
    
    public String halfOfString(String message, int start){
        StringBuilder mes = new StringBuilder(message);
        StringBuilder mesNew = new StringBuilder();
        for (int i=start;i<mes.length();i+=2){
            char currChar = mes.charAt(i);
            mesNew.append(currChar);
        }
        return mesNew.toString();
    }
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String input = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(17,3); 
        String encrypt = cc.encrypt(input);
        String decrypt = cc.decrypt(encrypt);
        
        System.out.println(encrypt);
        System.out.println(decrypt);
        
        breakCaesarCipher(encrypt);
    }
    
    public void breakCaesarCipher(String input){
        String first = halfOfString(input,0);
        String second = halfOfString(input,1);
        String first_D = decrypt0(first);
        String second_D = decrypt0(second);
        StringBuilder mesNew = new StringBuilder();
        for (int i=0;i<second_D.length();i++){
            char currChar = first_D.charAt(i);
            mesNew.append(currChar);
            char currChar2 = second_D.charAt(i);
            mesNew.append(currChar2);
            
        }
        
        
        System.out.println("breaker");
        System.out.println(mesNew.toString());
    
    }
    
    public String decrypt0(String encrypted){
        
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4 ){
            dkey = 26 - (4-maxDex);
        }
        CaesarCipher cc = new CaesarCipher(26-dkey);
        System.out.println(dkey);
        return cc.encrypt(encrypted);
    }
}
