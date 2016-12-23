Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (numRows > 0){
            temp = new ArrayList<>();
            temp.add(1);
            result.add(temp);
        }
        if (numRows > 1){
            temp = new ArrayList<>();
            temp.add(1);temp.add(1);
            result.add(temp);
        }
        for (int i = 2; i < numRows; i++){
            temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < result.get(i - 1).size() - 1; j++){
                temp.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
        
     
    }
}