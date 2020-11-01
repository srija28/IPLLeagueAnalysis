package opencsv;


import java.io.Reader;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public interface ICSVBuilder<T> {

	public <T> List<T> getCsvFileList(Reader reader, Class csvClass) throws CsvException;

}