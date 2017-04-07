package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
			JFileChooser chooser = new JFileChooser();
			File currentDirectory = new File("");
		    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
		    	currentDirectory = chooser.getSelectedFile();
		    	System.out.println(currentDirectory);
		    }
		    int result = JOptionPane.showConfirmDialog(null, "Confirm Darkest Dungeon Directory: " + currentDirectory, null, JOptionPane.YES_NO_OPTION);
		    if(result == JOptionPane.YES_OPTION){
		    	File file = new File("/skins");
		    	String[] directories = file.list(new FilenameFilter() {
		    	  @Override
		    	  public boolean accept(File current, String name) {
		    	    return new File(current, name).isDirectory();
		    	  }
		    	});
		    	System.out.println(Arrays.toString(directories));
		    }
		}
	}
		/*
		if(event.getSource() == removeButton){
			ClassList currentList = tabs.getListCurrent();
			if (currentList.getSelected() < currentList.length()){
				currentList.removeFile(currentList.getSelected());
				count--;
			}
		}
		
		if(event.getSource() == fixSkins){
			
		}
	}
	*/
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

	public String parseClass(String fileName){
		return fileName.substring(0, 2);
	}

}
