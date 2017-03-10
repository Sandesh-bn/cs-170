/*
 Given a list of people with their birth and death years, implement a method to 
compute the year with the most number of people alive. You may assume that all people were born 
between 1900 and 2000 (inclusive). If a person was alive during any portion of that year, they should 
be included in that year's count. For example, Person (birth= 1908, death= 1909) is included in the 
counts for both 1908 and 1909. 
*/
// The input can be two arrays of birth and death years
// or an array of person objects
// questions to ask: if person dies the same year of birth, is it counted as 1 year?

public class Person{
	private int birth, death;
	public Person(int birth, int death){
		this.birth = birth;
		this.death = death;
	}
	
	// getters and setters
}

int maxAliveYear(Person[] people, int start, int last){
	int max = 0, maxAliveYear = start;
	for (int year = start; year <= last; year++){
		int numberOfPeopleAlive = 0;
		for (Person person: people){
			if (person.getBirth() <= year && person.getDeath >= year)
				numberOfPeopleAlive++;
		}
		if (numberOfPeopleAlive > max){
			max = numberOfPeopleAlive;
			maxAliveYear = year;
		}
	}
	return maxAliveYear;
}
runtime is O(RP) R = range of years. P is number of people
