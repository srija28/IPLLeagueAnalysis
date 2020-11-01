package com.capgemini;

import java.io.IOException;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.SortByChoice.Choice;

public class IPLAnalyserTest {
	public String BOWLERS_CSV_FILE = "./Bowling.csv";
	public String BATSMEN_CSV_FILE = "./Batting.csv";
	public List<IPLLeagueBatsmen> batsmen = null;
	public List<IPLLeagueBowlers> bowlers = null;
	public IPLAnalyser obj;
	public SortByChoice c1;
	public List<IPLLeagueBatsmen> l1 = null;
	public List<IPLLeagueBowlers> l2 = null;

	public IPLAnalyserTest() {
		obj = new IPLAnalyser();
		c1 = new SortByChoice();
	}

	@Test
	public void givenBattingCSVfileReturnTopAverageBatsmen() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		l1 = c1.sortBychoice(Choice.BAT_AVG, batsmen);
		Assert.assertEquals("83.2", l1.get(0).avg);
	}
	
	@Test
 	public void givenBattingCSVfileReturnTopStrikingRateBatsman() {
 		try {
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l1 = c1.sortBychoice(Choice.STRIKE_RATE, batsmen);
 		Assert.assertEquals("333.33", l1.get(0).strikeRate);
 	}

}
