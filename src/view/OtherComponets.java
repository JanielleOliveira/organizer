package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class OtherComponets extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtherComponets frame = new OtherComponets();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OtherComponets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jPanelEmptyList = new JPanel();
		jPanelEmptyList.setLayout(null);
		jPanelEmptyList.setForeground(Color.WHITE);
		jPanelEmptyList.setBackground(Color.WHITE);
		jPanelEmptyList.setBounds(10, 11, 416, 467);
		contentPane.add(jPanelEmptyList);
		
		JLabel EmptyListIcon = new JLabel("");
		EmptyListIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		EmptyListIcon.setHorizontalAlignment(SwingConstants.CENTER);
		EmptyListIcon.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		EmptyListIcon.setBounds(10, 135, 400, 136);
		jPanelEmptyList.add(EmptyListIcon);
		
		JLabel EmptyListTitle = new JLabel("Nenhuma tarefa por aqui :D");
		EmptyListTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		EmptyListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		EmptyListTitle.setForeground(new Color(11, 166, 104));
		EmptyListTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
		EmptyListTitle.setBounds(10, 282, 400, 20);
		jPanelEmptyList.add(EmptyListTitle);
		
		JLabel EmptyListSubTitle = new JLabel("clique no botão  \"+\"  para adicionar uma nova tarefa!");
		EmptyListSubTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		EmptyListSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		EmptyListSubTitle.setForeground(Color.LIGHT_GRAY);
		EmptyListSubTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
		EmptyListSubTitle.setBounds(10, 301, 400, 14);
		jPanelEmptyList.add(EmptyListSubTitle);
	}

}
