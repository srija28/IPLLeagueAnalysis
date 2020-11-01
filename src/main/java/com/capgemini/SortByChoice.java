package com.capgemini;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByChoice<T> {

	public enum Choice {
		BAT_AVG, STRIKE_RATE, MAX_FOURS, MAX_SIXES, MAX_BOUNDARIES_AND_SR, MAX_AVG_AND_SR, MAX_RUNS_AND_BEST_AVG,
		BOWL_AVG, BOWL_STRIKE_RATE, BOWL_ECON, BEST_SR_AND_WKTS, BEST_SR_AND_AVG_BOWL, MAX_WKTS_AND_BEST_AVG,
 		MAX_BAT_AND_BOWL_AVG, BEST_ALL_ROUNDER, MAX_100_AND_BEST_BAT_AVG;
	}

	public Choice choice;

	@SuppressWarnings("unchecked")
	public List<T> sortBychoice(Choice choice, List<T> list) {
		String choice1 = choice.toString();
		String type5 = list.get(0).getClass().toString();
		List<IPLLeagueBatsmen> list1 = null;
		List<IPLLeagueBowlers> list3 = null;
		List<IPLLeagueAllRounder> list2 = null;
		if (type5.contains("IPLLeagueBatsmen")) {
			list1 = (List<IPLLeagueBatsmen>) list;
		} else if (type5.contains("IPLLeagueBowlers")) {
			list3 = (List<IPLLeagueBowlers>) list;
		}else if (type5.contains("IPLLeagueAllRounder")) {
 			list2 = (List<IPLLeagueAllRounder>) list;
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
		case "BEST_SR_AND_AVG_BOWL": {
 			Comparator<IPLLeagueBowlers> compareBy = Comparator.comparing(IPLLeagueBowlers::Average)
 					.thenComparing(IPLLeagueBowlers::StrikeRate);
 			Collections.sort(list3, compareBy);
 			return (List<T>) list3;
 		}
		case "MAX_WKTS_AND_BEST_AVG": {
 			Comparator<IPLLeagueBowlers> compareBy = Comparator.comparing(IPLLeagueBowlers::Wickets)
 					.thenComparing(IPLLeagueBowlers::Average);
 			Collections.sort(list3, compareBy.reversed());
 			return (List<T>) list3;
 		}
		case "MAX_BAT_AND_BOWL_AVG": {
 			Comparator<IPLLeagueAllRounder> compareBy = Comparator.comparing(IPLLeagueAllRounder::AverageWickets)
 					.thenComparing(IPLLeagueAllRounder::AverageRuns).reversed();
 			Collections.sort(list2, compareBy);
 			return (List<T>) list2;
 		}
		case "BEST_ALL_ROUNDER": {
 			Comparator<IPLLeagueAllRounder> compareBy = Comparator.comparing(IPLLeagueAllRounder::Runs)
 					.thenComparing(IPLLeagueAllRounder::Wickets).reversed();
 			Collections.sort(list2, compareBy);
 			return (List<T>) list2;
 		}
		case "MAX_100_AND_BEST_BAT_AVG": {
 			Comparator<IPLLeagueBatsmen> compareBy = Comparator.comparing(IPLLeagueBatsmen::Hundreds)
 					.thenComparing(IPLLeagueBatsmen::Average);
 			Collections.sort(list1, compareBy.reversed());
 			return (List<T>) list1;
 		}
		default: {
			System.out.println("Wrong choice entered!");
			return null;
		}
		}
	}
	public List<IPLLeagueAllRounder> getAllRounderPlayers(List<IPLLeagueBatsmen> batsmenList,
 			List<IPLLeagueBowlers> bowlersList) {
 		List<IPLLeagueAllRounder> allRounderList = new ArrayList<>();
 		for (IPLLeagueBatsmen b1 : batsmenList) {
 			IPLLeagueBowlers bowlers = bowlersList.stream().filter(bowler -> bowler.player.equalsIgnoreCase(b1.player))
 					.findFirst().orElse(null);
 			if (bowlers != null) {
 				allRounderList.add(new IPLLeagueAllRounder(b1.player, b1.runs, bowlers.wickets, b1.avg, bowlers.avg));
 			}
 		}
 		return allRounderList;
 	}

}