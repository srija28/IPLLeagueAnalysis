package com.capgemini;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByChoice<T> {

	public enum Choice {
		BAT_AVG, STRIKE_RATE, MAX_FOURS, MAX_SIXES, MAX_BOUNDARIES_AND_SR, MAX_AVG_AND_SR, MAX_RUNS_AND_BEST_AVG,
		BOWL_AVG,  BOWL_STRIKE_RATE, BOWL_ECON, BEST_SR_AND_WKTS;
	}

	public Choice choice;

	@SuppressWarnings("unchecked")
	public List<T> sortBychoice(Choice choice, List<T> list) {
		String choice1 = choice.toString();
		String type5 = list.get(0).getClass().toString();
		List<IPLLeagueBatsmen> list1 = null;
		List<IPLLeagueBowlers> list3 = null;
		if (type5.contains("IPLLeagueBatsmen")) {
			list1 = (List<IPLLeagueBatsmen>) list;
		} else if (type5.contains("IPLLeagueBowlers")) {
			list3 = (List<IPLLeagueBowlers>) list;
		}
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
		case "MAX_AVG_AND_SR": {
			Comparator<IPLLeagueBatsmen> compareBy = Comparator.comparing(IPLLeagueBatsmen::Average)
					.thenComparing(IPLLeagueBatsmen::StrikeRate);
			Collections.sort(list1, compareBy.reversed());
			return (List<T>) list1;
		}
		case "MAX_RUNS_AND_BEST_AVG": {
			Comparator<IPLLeagueBatsmen> compareBy = Comparator.comparing(IPLLeagueBatsmen::Runs)
					.thenComparing(IPLLeagueBatsmen::Average);
			Collections.sort(list1, compareBy.reversed());
			return (List<T>) list1;
		}
		case "BOWL_AVG": {
			Collections.sort(list3, Comparator.comparing(bowlers -> ((IPLLeagueBowlers) bowlers).Average()).reversed());
			return (List<T>) list3;
		}
		case "BOWL_STRIKE_RATE": {
 			Collections.sort(list3, Comparator.comparing(bowlers -> ((IPLLeagueBowlers) bowlers).StrikeRate()));
 			return (List<T>) list3;
 		}
		
		case "BEST_SR_AND_WKTS": {
 			Comparator<IPLLeagueBowlers> compareBy = Comparator.comparing(IPLLeagueBowlers::StrikeRate)
 					.thenComparing(IPLLeagueBowlers::Total4wsAnd5ws);
 			Collections.sort(list3, compareBy);
 			return (List<T>) list3;
 		}
		default: {
			System.out.println("Wrong choice entered!");
			return null;
		}
		}
	}

}