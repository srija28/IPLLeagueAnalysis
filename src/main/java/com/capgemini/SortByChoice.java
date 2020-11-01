package com.capgemini;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//this class performs the sort operation
public class SortByChoice<T> {

	public enum Choice {
		BAT_AVG;
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
		default: {
			System.out.println("Wrong choice entered!");
			return null;
		}
		}
	}

}