 How would you compute the k stars which are closest to the Earth?
You have only a few megabytes of R.AJ\.1.
use maxHeap of size k to store stars based on their distance. so that at any given time the farthest star will be at the head of the priorityqueue.
whenever you come across a star that is closer than any of the k stars, poll the heap and insert the new star.