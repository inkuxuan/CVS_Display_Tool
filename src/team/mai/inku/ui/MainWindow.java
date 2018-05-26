package team.mai.inku.ui;

import team.mai.inku.io.CsvFile;
import team.mai.inku.io.CsvReader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOException;

public class MainWindow extends JFrame {

	//fields
	private String sPath;
	//SWING components
	private JPanel contentPane;
	private JTable table;
	private TableModel tableModel;
	private JScrollPane scrollPane;


	public MainWindow(String sPath) throws IOException {
		this.sPath = sPath;
		CsvReader reader = new CsvReader(sPath);
		tableModel = new CsvTableModel(reader.readCsvFile());
		initUI();
		reader = null;
	}

	private void initUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 535);
		setTitle(sPath);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		table = new JTable(tableModel);

		scrollPane = new JScrollPane(table);

		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	static {
		// set default system look-and-feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
