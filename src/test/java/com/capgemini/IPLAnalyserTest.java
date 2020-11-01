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
	public List<IPLLeagueAllRounder> l3 = null;

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
	@Test
 	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumFours() {
 		try {
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l1 = c1.sortBychoice(Choice.MAX_FOURS, batsmen);
 		Assert.assertEquals("Shikhar Dhawan", l1.get(0).player);
 	}
 	
 	@Test
 	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumSixes() {
 		try {
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l1 = c1.sortBychoice(Choice.MAX_SIXES, batsmen);
 		Assert.assertEquals("Andre Russell", l1.get(0).player);
 	}
 	
 	@Test
 	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumBoundariesAndBestSR() {
 		try {
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l1 = c1.sortBychoice(Choice.MAX_BOUNDARIES_AND_SR, batsmen);
 		Assert.assertEquals("Ishant Sharma", l1.get(0).player);
 	}
 	@Test
 	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumAverageAndSR() {
 		try {
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l1 = c1.sortBychoice(Choice.MAX_AVG_AND_SR, batsmen);
 		Assert.assertEquals("MS Dhoni", l1.get(0).player);
 	}
 	@Test
 	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumrunsAndBestAverage() {
 		try {
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l1 = c1.sortBychoice(Choice.MAX_RUNS_AND_BEST_AVG, batsmen);
 		Assert.assertEquals("David Warner ", l1.get(0).player);
 	}
 	@Test
	public void givenBowlingCSVfileReturnTopAverageBowler() {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		l2 = c1.sortBychoice(Choice.BOWL_AVG, bowlers);
		Assert.assertEquals("11", l2.get(0).avg);
	}
 	@Test
 	public void givenBowlingCSVfileReturnTopSRBowler() {
 		try {
 			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l2 = c1.sortBychoice(Choice.BOWL_STRIKE_RATE, bowlers);
 		Assert.assertEquals("Alzarri Joseph", l2.get(0).player);
 	}
 	
 	@Test
 	public void givenBowlingCSVfileReturnTopEconomyRateBowler() {
 		try {
 			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l2 = c1.sortBychoice(Choice.BOWL_ECON, bowlers);
 		Assert.assertEquals("Shivam Dube", l2.get(0).player);
 	}
 	@Test
 	public void givenBowlingCSVfileReturnTopStrikeRateBowlerWithMaximumWickets() {
 		try {
 			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l2 = c1.sortBychoice(Choice.BEST_SR_AND_WKTS, bowlers);
 		Assert.assertEquals("Alzarri Joseph", l2.get(0).player);
 	}
 	@Test
 	public void givenBowlingCSVfileReturnTopStrikeRateBowlerWithBestAverage() {
 		try {
 			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l2 = c1.sortBychoice(Choice.BEST_SR_AND_AVG_BOWL, bowlers);
 		Assert.assertEquals("Anukul Roy", l2.get(0).player);
 	}
 	@Test
 	public void givenBowlingCSVfileReturnTopStrikeRateBowlerWithMaximumWickets_() {
 		try {
 			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l2 = c1.sortBychoice(Choice.MAX_WKTS_AND_BEST_AVG, bowlers);
 		Assert.assertEquals("Imran Tahir", l2.get(0).player);
 	}
 	@Test
 	public void givenBattingandbowlingfileReturnBestBattingAndBowlingAverages() {
 		try {
 			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l3 = c1.getAllRounderPlayers(batsmen, bowlers);
 		List<IPLLeagueAllRounder> l4 = c1.sortBychoice(Choice.MAX_BAT_AND_BOWL_AVG, l3);
 		Assert.assertEquals("Krishnappa Gowtham", l4.get(0).Player());
 	}
 	@Test
 	public void givenBattingandbowlingfileReturnBestAllRounder() {
 		try {
 			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l3 = c1.getAllRounderPlayers(batsmen, bowlers);
 		List<IPLLeagueAllRounder> l4 = c1.sortBychoice(Choice.BEST_ALL_ROUNDER, l3);
 		Assert.assertEquals("Andre Russell", l4.get(0).Player());
 	}
 	@Test
 	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximum100AndBestBattingAvg() {
 		try {
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l1 = c1.sortBychoice(Choice.MAX_100_AND_BEST_BAT_AVG, batsmen);
 		Assert.assertEquals("David Warner", l1.get(0).player);
 	}
	@Test
 	public void givenBattingCSVfile_ShouldReturnPlayerWithZero100sAand50sButBestBattibgAvgs() {
 		try {
 			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
 		} catch (IPLLeagueAnalyserException e) {
 			e.printStackTrace();
 		}
 		l1 = c1.sortBychoice(Choice.ZERO_100S_AND_50S_BUT_BEST_BAT_AVG, batsmen);
 		Assert.assertEquals("Marcus Stoinis", l1.get(0).player);
 	}

}
