package team.mai.inku.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CsvRow extends ArrayList<String> {
	public CsvRow() {
	}

	public CsvRow(Collection<? extends String> c) {
		super(c);
	}

	public CsvRow(String... columns) {
		super(Arrays.asList(columns));
	}
}
