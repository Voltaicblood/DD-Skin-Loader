package main;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ClassList extends JList<String> {

	private DefaultListModel<String> listModel;
	private JScrollPane listScrollPane;
	private int selected;
	private int length;
	
	public ClassList(){
		listModel = new DefaultListModel<String>();
		this.setModel(listModel);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setVisibleRowCount(-1);
		listScrollPane = new JScrollPane(this);
		this.setVisible(true);
	}
	
	public void addFile(String fileName){
		listModel.addElement(fileName);
		length++;
	}
	
	public void removeFile(int index){
		listModel.removeElementAt(index);
		length--;
	}
	
	public int length(){
		return this.length;
	}
	
	public int getSelected(){
		selected = this.getSelectedIndex();
		return selected;
	}
}
