package team.mai.inku.ui;

import team.mai.inku.io.CsvFile;

import javax.swing.table.AbstractTableModel;

public class CsvTableModel extends AbstractTableModel {

	private CsvFile csvFile;
	private boolean headerPresent;
	private boolean rowsPresent;

	public CsvTableModel(CsvFile csvFile) {
		if (csvFile == null)
			throw new IllegalArgumentException("CSV File for Csv Table Model initialization cannot be null");
		this.csvFile = csvFile;
		headerPresent = csvFile.hasHeader();
		rowsPresent = csvFile.hasRow();
	}

	@Override
	public int getRowCount() {
		if (!headerPresent)
			return 0;
		if (!rowsPresent)
			return 1;
		return csvFile.getRows().size() + 1;
	}

	@Override
	public int getColumnCount() {
		if(!headerPresent)
			return 0;
		return csvFile.getHeader().size();
	}

	@Override
	public String getColumnName(int columnIndex) {
//		if(csvFile.getHeaderContent(columnIndex)==null)
//			System.err.println("Null header content at "+ columnIndex);
		return csvFile.getHeaderContent(columnIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return csvFile.getCell(rowIndex, columnIndex);
	}
}
