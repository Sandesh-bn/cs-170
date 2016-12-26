/* 
# There's a room with a TV and people are coming in and out to watch it. The TV is on only when there's at least a person in the room. 
# For each person that comes in, we record the start and end time. We want to know for how long the TV has been on. In other words: 
# Given a list of arrays of time intervals, write a function that calculates the total amount of time covered by the intervals. 
# For example: 

# input = [(1,4), (2,3)] 
# > 3 
# input = [(4,6), (1,2)] 
# > 3 
# input = [(1,4), (6,8), (2,4), (7,9), (10, 15)] 
# > 11 
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

  public static void tvOn(ArrayList<String> timeInterval) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (String s : timeInterval) {
          s = s.replaceAll("[()]", "");
          String[] interval = s.split(",");
          map.put(Integer.valueOf(interval[0]), Integer.valueOf(interval[1]));
      }
      int newStart;
      int newEnd;
      Set<Integer> startTime = map.keySet();
      ArrayList<Integer> start = new ArrayList<>(startTime);
      Collections.sort(start);
      for (int k = 0; k < start.size(); k++) {
        if (start.get(k) == -1)
          continue;
        for (int i = k + 1; i < start.size(); i++) {
          if (start.get(i) == -1)
           continue;
          
          if (start.get(i) < map.get(start.get(k))) {
          
            newStart = start.get(k);
            newEnd = Math.max(map.get(start.get(k)), map.get(start.get(i)));
            map.remove(start.get(i));
            start.set(i, -1);
            map.put(newStart, newEnd);
          }
        
        }
      
      }
      int sum = 0;
      for (Entry entry : map.entrySet()) {
        int x = (int) entry.getKey();
        int y = (int) entry.getValue();
        sum += y - x;
      }
      System.out.println(sum);
  }
  
  public static void main(String[] args) {
    ArrayList<String> timeInterval = new ArrayList<String>();
   /* timeInterval.add("(1,4)");
    timeInterval.add("(2,9)");
    timeInterval.add("(5,8)");
    timeInterval.add("11,15");
    timeInterval.add("21,25");
    */
    /*
    timeInterval.add("1,4");
    timeInterval.add("6,8");
    timeInterval.add("2,4");
    timeInterval.add("7,9");
    timeInterval.add("10,15");
    */
    timeInterval.add("1,4");
    timeInterval.add("2,3");
    
    tvOn(timeInterval);
  
  }
}