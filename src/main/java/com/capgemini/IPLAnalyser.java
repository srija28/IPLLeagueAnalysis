package com.capgemini;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.exceptions.CsvException;
import opencsv.CSVBuilderFactory;
import opencsv.ICSVBuilder;
import com.capgemini.IPLLeagueAnalyserException.ExceptionType;

public class IPLAnalyser<T> {

	public static List<IPLLeagueBatsmen> batsmenList;
	public static List<IPLLeagueBowlers> bowlersList;

	public IPLAnalyser() {
		batsmenList = null;
		bowlersList = null;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> readData(String DATA_FILE, String type) throws IPLLeagueAnalyserException {
		if (!DATA_FILE.contains(".csv")) {
			throw new IPLLeagueAnalyserException(ExceptionType.INVALID_FILE_TYPE,
					"Invalid File Type!! \nInvalidTypeException thrown....");
		}
		try (Reader reader = Files.newBufferedReader(Paths.get(DATA_FILE))) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			if (type.equalsIgnoreCase("batsmen")) {
				try {
					batsmenList = csvBuilder.getCsvFileList(reader, IPLLeagueBatsmen.class);
					return (List<T>) batsmenList;
				} catch (CsvException e) {
					throw new IPLLeagueAnalyserException(ExceptionType.INVALID_CLASS_TYPE,
							"Invalid Class Type!! \nInvalidClassTypeException thrown... ");
				}
			} else if (type.equalsIgnoreCase("bowlers")) {
				try {
					bowlersList = csvBuilder.getCsvFileList(reader, IPLLeagueBowlers.class);
					return (List<T>) bowlersList;
				} catch (CsvException e) {
					throw new IPLLeagueAnalyserException(ExceptionType.INVALID_CLASS_TYPE,
							"Invalid Class Type!! \nInvalidClassTypeException thrown... ");
				}
			} else {
				throw new IPLLeagueAnalyserException(ExceptionType.INVALID_PLAYER_TYPE,
						"Invalid player type!! \nInvalidPlayerTypeException thrown... ");
			}

		} catch (IOException e) {
			throw new IPLLeagueAnalyserException(ExceptionType.INVALID_FILE_PATH,
					"Invalid file location given!! \nInvalidFilePAthException thrown...");
		}

	}

}