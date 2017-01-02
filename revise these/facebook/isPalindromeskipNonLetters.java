public static  boolean isPal(String val){
    int N = val.length();
    if (N < 2) return true;
    int i = 0, j = N - 1;
    while (i < j){
      while(i < j && !Character.isAlphabetic(val.charAt(i)))
        i++;
      if (i >= j)
        return true;
      char chI = Character.toLowerCase(val.charAt(i));
      
      while (i < j && !Character.isAlphabetic(val.charAt(j)))
        j--;
      if (i >= j)
        return true;
      char chJ = Character.toLowerCase(val.charAt(j));
      
      if (chI != chJ)
        return false;
      i++;
      j--;
      
    }
    return true;
  }