
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;
    
    public CaesarCipherTwo(int key1,int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        key1 = key1;
        key2 = key2;
    }
    
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                if (i%2==0){
                char newChar = shiftedAlphabet1.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
            else{
                char newChar = shiftedAlphabet2.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
            }

        }
        return encrypted.toString();
    } 
    
    public String decrypt(String input){
        String first = halfOfString(input,0);
        String second = halfOfString(input,1);
        String first_D = decrypt(first,key1);
        String second_D = decrypt(second,key2);
        StringBuilder mesNew = new StringBuilder();
        for (int i=0;i<second_D.length();i++){
            char currChar = first_D.charAt(i);
            mesNew.append(currChar);
            char currChar2 = second_D.charAt(i);
            mesNew.append(currChar2);
            
        }
        
        return mesNew.toString();
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
    
    public String decrypt(String encrypted,int key){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        CaesarCipher cc = new CaesarCipher(key);
        System.out.println(key);
        return cc.encrypt(encrypted);
    }

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
}
