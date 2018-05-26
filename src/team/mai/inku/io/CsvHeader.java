package team.mai.inku.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CsvHeader extends ArrayList<String> {
	public CsvHeader() {
	}

	public CsvHeader(Collection<? extends String> c) {
		super(c);
	}

	public CsvHeader(String... headers) {
		super(Arrays.asList(headers));
	}

}
