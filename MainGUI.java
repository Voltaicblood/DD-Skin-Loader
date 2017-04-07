package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainGUI extends JPanel implements ActionListener{
	
	private JButton loadButton = new JButton("Load Skins");;
	private JButton removeButton = new JButton("Remove Skins");;
	private JPanel buttonPane = new JPanel();
	private JButton fixSkins = new JButton("Fix Skin Folders");
	private ClassTabs tabs = new ClassTabs();
	int count = 0;

	public MainGUI(){
		setLayout(new BorderLayout());
		//fileList.addListSelectionListener(this);
		
		loadButton.addActionListener(this);
		removeButton.addActionListener(this);
		fixSkins.addActionListener(this);
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.add(loadButton);
		buttonPane.add(fixSkins);
		buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
		buttonPane.add(removeButton);
		buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		add(tabs, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.PAGE_END);
		}
		

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == loadButton){
			ClassList currentList = tabs.addTab("Test" + count);
			int index = 5;
			while(index > 0){
				currentList.addFile("Item #" + count);
				count++;
				index--;
			}
		}
		
		if(event.getSource() == removeButton){
			ClassList currentList = tabs.getList();
			if (currentList.getSelected() < currentList.length()){
				currentList.removeFile(currentList.getSelected());
				count--;
			}
		}
		
		if(event.getSource() == fixSkins){
			
		}
	}
	
	public static void createAndShowGUI(){
		JFrame frame = new JFrame("Darkest Dungeon Skin Loader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new MainGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.setSize(600, 600);
		//frame.pack();
		frame.setVisible(true);
	}



}
