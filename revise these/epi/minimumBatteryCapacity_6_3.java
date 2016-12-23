// Problem 6.3
// Design an algorithm that takes a sequence of n three-dimentional
// coordinates to be traversed, and return the minimum battery capacity needed to
// complete the journey. The robot begins with a fully charged battery.


// input is list of z coordinates to be traveled by robot.

public int minimumCapacity(int[] Z){
	if (Z.length <= 1) return 0;
	int maxDiff = 0;
	int minHeight = Z[0];
	for (int i = 1; i < Z.length; i++){
		// update differene to min height
		maxDiff = Math.max(maxDiff, Z[i] - minHeight);
		
		// update minimum height
		minHeight = Math.min(Z[i], minHeight);
	}
	return maxDiff;
}
