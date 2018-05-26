package team.mai.inku.io;

import java.util.ArrayList;
import java.util.List;

public class CsvFile {

	private CsvHeader header;
	private List<CsvRow> rows;

	public CsvFile(CsvHeader header, List<CsvRow> rows) {
		this.header = header;
		this.rows = rows;
	}

	/**
	 * <p>instantiates a CsvFile without any row.</p>
	 * <p>rows will be an empty {@code ArrayList<CsvRows>}</p>
	 */
	public CsvFile(CsvHeader header) {
		this.header = header;
		rows = new ArrayList<CsvRow>();
	}

	/**
	 * <p>instantiates a CsvFile without any row or header.</p>
	 * <p>rows will be an empty {@code ArrayList}</p>
	 * <p>header will be a default {@code CsvHeader}</p>
	 */
	public CsvFile() {
		header = new CsvHeader();
		rows = new ArrayList<CsvRow>();
	}

	/**
	 * gets the content of the specified cell
	 *
	 * @param row row index starting from 0, header row is exclusive
	 * @param col column number starting from 1
	 * @return content of the specified cell, null if index is out of bound
	 */
	public String getCell(int row, int col) {
		try {
			return rows.get(row).get(col);
		} catch (IndexOutOfBoundsException e){
			return null;
		}
	}

	/**
	 * gets the specified row in {@link CsvRow}
	 *
	 * @param row row index starting from 0
	 * @return the specified row in {@link CsvRow}, null if index is out of bound
	 */
	public CsvRow getRow(int row) {
		try {
			return rows.get(row);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * gets the specified header content
	 *
	 * @param col column index starting from 0
	 * @return the specified header content, null if index is out of bound
	 */
	public String getHeaderContent(int col) {
		try {
			return header.get(col);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public boolean hasHeader(){
		return header!=null;
	}

	public boolean hasRow(){
		return rows!=null;
	}

	public CsvHeader getHeader() {
		return header;
	}

	//package private
	void setHeader(CsvHeader header) {
		this.header = header;
	}

	public List<CsvRow> getRows() {
		return rows;
	}

	//package private
	void setRows(List<CsvRow> rows) {
		this.rows = rows;
	}

	//package private
	void appendRow(CsvRow row){
		this.rows.add(row);
	}
}
