package gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import data.*;

/**
 * Main Application Window(Frame) containing the main menu bar with a scrollable
 * list of students to the left and a text box to filter the list above it.
 * @author CBaker
 *
 */
public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 6495403463870876094L;
	/**
	 * JFrame Field that is populated when a StudentInformation pop-up window is constructed
	 * so that the panel can be updated with a newly selected Student's details, instead of
	 * constructing a new Frame each time should a pop-up window of already exist.
	 */
	private StudentInformation informationPanel;
	private StudentRecords records;
	/**
	 * Text box Field so an event listener can be attached and filter list as the
	 * user types.
	 */
	private JTextField txtFilterStudents;
	
	/**
	 * Default Constructor that constructs the main application window along with
	 * the components. 
	 */
	public MainWindow()
	{
		setTitle("Students Application");
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		records = new StudentRecords();
		
		JMenuBar jmbMainMenu = new JMenuBar();
		setJMenuBar(jmbMainMenu);
		
			JMenu jmFile = new JMenu("File");	
			jmbMainMenu.add(jmFile);			
			
			JMenu jmData = new JMenu("Data");
			jmbMainMenu.add(jmData);
		
		
		JPanel jpStudentsList = new JPanel(new BorderLayout());
		add(jpStudentsList, BorderLayout.WEST);
		
			txtFilterStudents = new JTextField(20);
			jpStudentsList.add(txtFilterStudents, BorderLayout.NORTH);
		
			JList<Object> jlStudents = new JList<>(records.getAllStudents().toArray());
			jlStudents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane jspList = new JScrollPane(jlStudents);
			jpStudentsList.add(jspList, BorderLayout.CENTER);
			jlStudents.addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent e)
				{
					Student currentSelected = (Student) jlStudents.getSelectedValue();
					
					if(informationPanel == null)
					{
						informationPanel = new StudentInformation(currentSelected, MainWindow.this);
					}
					else
					{
						informationPanel.updateStudentDetails(currentSelected);
						informationPanel.addWindowListener(new WindowListener() {

							@Override
							public void windowOpened(WindowEvent e)
							{	
								int width = jpStudentsList.getWidth() + 10;
								Point point = txtFilterStudents.getLocationOnScreen();
								int y = (int) point.getY() + 3;
								
								informationPanel.setLocation(width, y);
							}

							@Override
							public void windowClosing(WindowEvent e)
							{
								informationPanel = null;
							}

							@Override
							public void windowClosed(WindowEvent e)
							{
								
							}

							@Override
							public void windowIconified(WindowEvent e)
							{
								
							}

							@Override
							public void windowDeiconified(WindowEvent e)
							{
								
							}

							@Override
							public void windowActivated(WindowEvent e)
							{
								
							}

							@Override
							public void windowDeactivated(WindowEvent e)
							{
								
							}
							
						});
					}
				}
				
			});
		
		informationPanel = null;
		
		
		pack();
		setVisible(true);
	}
	
	
	/**
	 * for testing this class
	 * @param args
	 */
	public static void main(String[] args)
	{
		MainWindow mainWindow = new MainWindow();
	}
	
	

}
