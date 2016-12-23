You aregiven a sequence of users where eachuser has a unique 32-bit
integer key and a set of attributes specified as strings. When you read a user, you should
pair that user with another previously read user with identical attributes who is currently
unpaired, if such a user exists. If the user cannot be paired, you should keep him in the
unpaired set. How would you implement this matching process efficiently?


Solution 12.5: Each user is associated with a set of attributes and we need to find
users associated with a given set of attributes quickly.Ahash table would be a perfect
solution here but we need a hash function over the set of attributes. If the number of
attributes is small, we can represent a subset of attributes as a bit array, where each
bit represents a specific attribute. Once we have a canonical representation for sets,
then we can use any hash function for bit arrays.
If the set of possible attributes is large, a better way to canonically represent a
subset of attributes is to sort the attributes. (Any arbitrary ordering of attributes will
work.) Wecan represent the sorted sequence of attributes as a string by concatenating
the individual elements, and use a hash function for strings.