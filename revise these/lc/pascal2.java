Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

public List<Integer> getRow(int rowIndex) {
        
        
        List<List<Integer>> pascal = new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        pascal.add(temp);
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        pascal.add(temp);
        if (rowIndex < 2)
            return pascal.get(rowIndex);
            
        for (int i = 2; i <= rowIndex; i++){
            pascal.remove(0);
            temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < pascal.get(0).size() - 1; j++)
                temp.add(pascal.get(0).get(j) + pascal.get(0).get(j + 1));
                
            temp.add(1);
            pascal.add(temp);
        }
        return pascal.get(1);
    
    }