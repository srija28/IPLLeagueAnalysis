package com.capgemini;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//this class performs the sort operation
public class SortByChoice<T> {

	public enum Choice {
		BAT_AVG, STRIKE_RATE, MAX_FOURS, MAX_SIXES, MAX_BOUNDARIES_AND_SR;
	}

	public Choice choice;

	@SuppressWarnings("unchecked")
	public List<T> sortBychoice(Choice choice, List<T> list) {
		String choice1 = choice.toString();
		List<IPLLeagueBatsmen> list1 = (List<IPLLeagueBatsmen>) list;
		switch (choice1) {
		case "BAT_AVG": {
			Collections.sort(list1, Comparator.comparing(batsmen -> ((IPLLeagueBatsmen) batsmen).Average()).reversed());
			return (List<T>) list1;
		}
		case "STRIKE_RATE": {
			Collections.sort(list1,
					Comparator.comparing(batsmen -> ((IPLLeagueBatsmen) batsmen).StrikeRate()).reversed());
			return (List<T>) list1;
		}
		case "MAX_FOURS": {
 			Collections.sort(list1,
 					Comparator.comparing(batsmen -> ((IPLLeagueBatsmen) batsmen).noOfFours()).reversed());
 			return (List<T>) list1;
 		}
 		case "MAX_SIXES": {
 			Collections.sort(list1,
 					Comparator.comparing(batsmen -> ((IPLLeagueBatsmen) batsmen).noOfSixes()).reversed());
 			return (List<T>) list1;
 		}
 		case "MAX_BOUNDARIES_AND_SR": {
 			Comparator<IPLLeagueBatsmen> compareBy = Comparator.comparing(IPLLeagueBatsmen::StrikeRate)
 					.thenComparing(IPLLeagueBatsmen::noOfBoundaries);
 			Collections.sort(list1, compareBy.reversed());
 			return (List<T>) list1;
 		}
		default: {
			System.out.println("Wrong choice entered!");
			return null;
		}
		}
	}

}