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



Suppose the three-dimensions correspond to x, y, and z, with z being
the vertical dimension. Since energy usage depends on the change in height of the
robot, we can ignore the x and y coordinates. Suppose the points where the robot
goes in successive order have z coordinates Zo, ... r Zn+ Assume that the battery
capacity is such that with the fully charged battery, the robot can climb B meters.
The robot will run out of energy iff there exist integers i and j such that i < j and
zj- Zi > B, i.e., to go from Point i to Point i.the robot has to climbmore than B meters.
Therefore,we would like to pick B such that for any i < j, we have B >= zJ - Zi.
