package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.ComponentOrientation;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DropMode;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private final JTable jTableTasks = new JTable();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// LookAndFeel alterado
				try {
		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Java swing".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
		        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
		            System.err.println(ex);
		        }  
				// fim LookAndFeel
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setMinimumSize(new Dimension(600, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel jPanelToolbar = new JPanel();
		jPanelToolbar.setBounds(0, 0, 634, 106);
		jPanelToolbar.setBackground(new Color(5, 146, 107));
		contentPane.add(jPanelToolbar);
		jPanelToolbar.setLayout(null);
		
		JLabel tooBarTitle = new JLabel(" Organizer");
		tooBarTitle.setBackground(new Color(5, 146, 107));
		tooBarTitle.setIcon(new ImageIcon("C:\\projetos\\organizer\\GradleOrganizer\\lib\\src\\main\\resources\\tick.png"));
		tooBarTitle.setForeground(new Color(255, 255, 255));
		tooBarTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
		tooBarTitle.setBounds(10, 11, 242, 64);
		jPanelToolbar.add(tooBarTitle);
		
		JLabel tooBarSubTitle = new JLabel("Anote tudo, não esqueça nada!");
		tooBarSubTitle.setForeground(new Color(255, 255, 255));
		tooBarSubTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
		tooBarSubTitle.setBounds(10, 78, 562, 20);
		jPanelToolbar.add(tooBarSubTitle);
		
		JPanel jPanelProjects = new JPanel();
		jPanelProjects.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanelProjects.setBounds(10, 117, 173, 40);
		jPanelProjects.setBackground(new Color(255, 255, 255));
		contentPane.add(jPanelProjects);
		jPanelProjects.setLayout(null);
		
		JLabel jLabelProjectsTitle = new JLabel("Projetos");
		jLabelProjectsTitle.setForeground(new Color(11, 166, 104));
		jLabelProjectsTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		jLabelProjectsTitle.setBounds(10, 0, 73, 40);
		jPanelProjects.add(jLabelProjectsTitle);
		
		JLabel jLabelProjectsAdd = new JLabel("");
		jLabelProjectsAdd.setIcon(new ImageIcon("C:\\projetos\\organizer\\GradleOrganizer\\lib\\src\\main\\resources\\add.png"));
		jLabelProjectsAdd.setBounds(111, 0, 38, 40);
		jPanelProjects.add(jLabelProjectsAdd);
		
		JPanel jPanelTasks = new JPanel();
		jPanelTasks.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanelTasks.setBounds(188, 117, 436, 40);
		jPanelTasks.setBackground(new Color(255, 255, 255));
		contentPane.add(jPanelTasks);
		jPanelTasks.setLayout(null);
		
		JLabel jLabelTasksTitle = new JLabel("Tarefas");
		jLabelTasksTitle.setForeground(new Color(11, 166, 104));
		jLabelTasksTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		jLabelTasksTitle.setBounds(10, 0, 300, 40);
		jPanelTasks.add(jLabelTasksTitle);
		
		JLabel jLabelTasksAdd = new JLabel("");
		jLabelTasksAdd.setIcon(new ImageIcon("C:\\projetos\\organizer\\GradleOrganizer\\lib\\src\\main\\resources\\add.png"));
		jLabelTasksAdd.setBounds(373, 0, 37, 40);
		jPanelTasks.add(jLabelTasksAdd);
		
		JPanel jPanelProjectList = new JPanel();
		jPanelProjectList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanelProjectList.setBounds(10, 161, 173, 489);
		jPanelProjectList.setBackground(new Color(255, 255, 255));
		contentPane.add(jPanelProjectList);
		jPanelProjectList.setLayout(null);
		
		JList ListProjects = new JList();
		ListProjects.setBackground(new Color(255, 255, 255));
		ListProjects.setBorder(new EmptyBorder(0, 0, 0, 0));
		ListProjects.setFixedCellHeight(50);
		ListProjects.setSelectionBackground(new Color(5, 146, 107));
		ListProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListProjects.setModel(new AbstractListModel() {
			String[] values = new String[] {"item 1", "item 2", "item 3", "item 4", "item 5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		ListProjects.setToolTipText("");
		ListProjects.setFont(new Font("Segoe UI", Font.BOLD, 18));
		ListProjects.setBounds(10, 11, 153, 467);
		jPanelProjectList.add(ListProjects);
		
		JPanel jScrolPanelTasks = new JPanel();
		jScrolPanelTasks.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jScrolPanelTasks.setBounds(188, 161, 436, 489);
		jScrolPanelTasks.setBackground(new Color(255, 255, 255));
		contentPane.add(jScrolPanelTasks);
		jScrolPanelTasks.setLayout(null);
		jTableTasks.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jTableTasks.setShowVerticalLines(false);
		jTableTasks.setSelectionForeground(new Color(255, 255, 255));
		jTableTasks.setName("");
		jTableTasks.setGridColor(new Color(255, 255, 255));
		jTableTasks.setRowHeight(50);
		jTableTasks.setSelectionBackground(new Color(5, 146, 107));
		jTableTasks.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jTableTasks.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", Boolean.FALSE},
				{"", null, null, Boolean.FALSE},
				{null, null, null, Boolean.FALSE},
				{null, null, null, Boolean.FALSE},
				{null, null, null, Boolean.FALSE},
				{null, null, null, Boolean.FALSE},
			},
			new String[] {
				"Nome", "Descri\u00E7\u00E3o", "Prazo", "Tarefa Conclu\u00EDda"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTableTasks.setBounds(10, 11, 416, 460);
		jScrolPanelTasks.add(jTableTasks);
	}
	

	
	
	
}
