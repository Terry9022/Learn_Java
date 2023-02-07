
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for (String line : fr.lines()) {
             LogEntry cur = WebLogParser.parseEntry(line);
             records.add(cur);
        }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry le : records){
             String ipAddr = le.getIpAddress();
             if(!uniqueIPs.contains(ipAddr)){
                 uniqueIPs.add(ipAddr);
                }
            }
         return uniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num){
         for(LogEntry le : records){
             int code = le.getStatusCode();
             if(code > num){
                 System.out.println(le);
                }
            }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry le : records){
             String ipAddr = le.getIpAddress();
             Date d = le.getAccessTime();
             String str = d.toString();
             str = str.substring(4,10);
             //System.out.println(str);
             if(!uniqueIPs.contains(ipAddr) && str.equals(someday)){
                 uniqueIPs.add(ipAddr);
                }
            }
         return uniqueIPs;
     }
     
     public int countUniqueIPsInRange(int low,int high){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry le : records){
             String ipAddr = le.getIpAddress();
             int code = le.getStatusCode();
             if(!uniqueIPs.contains(ipAddr) && code>=low && code<=high){
                 uniqueIPs.add(ipAddr);
                }
            }
         return uniqueIPs.size();
     }
}
