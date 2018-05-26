package team.mai.inku.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

	private String sPath;

	public CsvReader(String sPath) {
		this.sPath = sPath;
	}

	public CsvFile readCsvFile() throws IOException {
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(sPath))){
			CsvFile csvFile = new CsvFile();
			//Process header line
			String headerLine = bufferedReader.readLine();
			//In case of an empty file
			if(headerLine==null)
				return csvFile;
			String[] headers = headerLine.split(",");
			CsvHeader csvHeader = new CsvHeader();
			for(String header : headers){
				csvHeader.add(header.trim());
			}
			csvFile.setHeader(csvHeader);
			//Process contents
			String lineBuffer;
			while((lineBuffer = bufferedReader.readLine())!=null){
				CsvRow csvRow = new CsvRow();
				String[] cells = lineBuffer.split(",");
				for(String cell: cells){
					csvRow.add(cell.trim());
				}
				csvFile.appendRow(csvRow);
			}
			return csvFile;
		}
	}

	public String getsPath() {
		return sPath;
	}

	public void setsPath(String sPath) {
		this.sPath = sPath;
	}
}
