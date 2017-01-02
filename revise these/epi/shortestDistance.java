// given an array of words and word1 and word2.
// find the shortest distance
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.


public int shortestDistance(String[] words, String word1, String word2){
	int minDist = Integer.MAX_VALUE;
	int i1 = -1, i2 = -2;
	for (int i = 0; i < words.length; i++){
		if (words[i].equals(word1))
			i1 = i;
		else if (words[i].equals(word2))
			i2 = i;
		
		if (i1 != -1 && i2 != -1)
			minDist = Math.min(minDist, Math.abs(i1 - i2));
	}
	return minDist;
}