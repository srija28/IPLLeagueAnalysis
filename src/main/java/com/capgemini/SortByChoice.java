package com.capgemini;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//this class performs the sort operation
public class SortByChoice<T> {

	public enum Choice {
		BAT_AVG, STRIKE_RATE;
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
 			for (IPLLeagueBatsmen b1 : list1) {
 				if (b1.strikeRate.equals("-"))
 					b1.strikeRate = "0";
 			}
 			Collections.sort(list1,
 					Comparator.comparing(batsmen -> ((IPLLeagueBatsmen) batsmen).StrikeRate()).reversed());
 			return (List<T>) list1;
 		}
		default: {
			System.out.println("Wrong choice entered!");
			return null;
		}
		}
	}

}