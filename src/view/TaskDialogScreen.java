package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.Cursor;

public class TaskDialogScreen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TaskDialogScreen dialog = new TaskDialogScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TaskDialogScreen() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setMinimumSize(new Dimension(416, 600));
		setBounds(100, 100, 416, 565);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(5, 146, 107));
			panel.setBounds(0, 0, 400, 59);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Tarefa");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setBackground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
				lblNewLabel.setBounds(10, 0, 324, 60);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setIcon(new ImageIcon("C:\\projetos\\organizer\\GradleOrganizer\\lib\\src\\main\\resources\\check.png"));
				lblNewLabel_1.setBounds(344, 0, 46, 60);
				panel.add(lblNewLabel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(10, 65, 380, 452);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_2 = new JLabel("Nome");
				lblNewLabel_2.setForeground(new Color(0, 0, 0));
				lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				lblNewLabel_2.setBounds(10, 11, 360, 20);
				panel.add(lblNewLabel_2);
			}
			{
				textField = new JTextField();
				textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				textField.setBounds(10, 35, 360, 30);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Descrição");
				lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				lblNewLabel_3.setForeground(new Color(0, 0, 0));
				lblNewLabel_3.setBounds(10, 82, 360, 20);
				panel.add(lblNewLabel_3);
			}
			{
				JTextArea textArea = new JTextArea();
				textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				textArea.setBounds(10, 105, 360, 110);
				panel.add(textArea);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Prazo");
				lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				lblNewLabel_4.setBounds(10, 226, 360, 20);
				panel.add(lblNewLabel_4);
			}
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textField_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			textField_1.setBounds(10, 251, 360, 30);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Notas");
			lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblNewLabel_5.setBounds(10, 292, 360, 20);
			panel.add(lblNewLabel_5);
			
			JTextArea textArea = new JTextArea();
			textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textArea.setBounds(10, 323, 360, 118);
			panel.add(textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
