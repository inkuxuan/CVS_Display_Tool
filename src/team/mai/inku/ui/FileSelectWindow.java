package team.mai.inku.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.IOException;

/**
 * <p>A {@code FileSelectWindow} will launch a window
 * allowing user to select a csv file</p>
 * <p>Clicking at "Load File" will cause rendering a {@link MainWindow}
 * to display the cvs table</p>
 */
public class FileSelectWindow extends JFrame {

	private JPanel contentPane;
	private JTextField filePathField;
	private JButton loadButton;
	private JButton selectFileButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FileSelectWindow fileSelectWindow = new FileSelectWindow();
		fileSelectWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		fileSelectWindow.setVisible(true);
	}

	public FileSelectWindow() {
		initUI();
		initListeners();
	}

	private void initListeners() {
		selectFileButton.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser(filePathField.getText());
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setFileFilter(new FileNameExtensionFilter("CSV File", "csv"));
			fileChooser.showDialog(FileSelectWindow.this, "Open");
			filePathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
		});
		loadButton.addActionListener(e -> {
			try {
				MainWindow mainWindow = new MainWindow(filePathField.getText());
				mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				this.setVisible(false);
				mainWindow.setVisible(true);
			} catch (IOException ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(FileSelectWindow.this,
						"Invalid File (IO Error)", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	private void initUI() {
		setResizable(false);
		setBounds(100, 100, 561, 222);
		setTitle("Select CSV File");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		filePathField = new JTextField();
		filePathField.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		filePathField.setBounds(27, 54, 360, 34);
		contentPane.add(filePathField);
		filePathField.setColumns(10);

		JLabel fileLabel = new JLabel("CSV File");
		fileLabel.setBounds(27, 29, 132, 18);
		contentPane.add(fileLabel);

		selectFileButton = new JButton("...");
		selectFileButton.setBounds(401, 54, 80, 34);
		contentPane.add(selectFileButton);

		loadButton = new JButton("Load File");
		loadButton.setBounds(27, 121, 113, 27);
		contentPane.add(loadButton);
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
