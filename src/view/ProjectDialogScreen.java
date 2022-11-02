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
import java.awt.Dimension;

public class ProjectDialogScreen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProjectDialogScreen dialog = new ProjectDialogScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProjectDialogScreen() {
		setMinimumSize(new Dimension(416, 500));
		setBounds(100, 100, 416, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(5, 146, 107));
		panel.setBounds(0, 0, 400, 59);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Projeto");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(10, -2, 321, 60);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(342, 0, 48, 58);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\projetos\\organizer\\GradleOrganizer\\lib\\src\\main\\resources\\check.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 61, 380, 356);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 11, 360, 20);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField.setBounds(10, 37, 360, 33);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descrição");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 91, 360, 20);
		panel_1.add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textArea.setBounds(10, 122, 360, 223);
		panel_1.add(textArea);
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
