package main;

import javax.swing.JTabbedPane;

public class ClassTabs extends JTabbedPane {
	
	String[] classes;
	
	public ClassTabs(){
		classes = new String[20];
	}
	
	public ClassList addTab(String tabName){
		ClassList inputClass = new ClassList();
		add(inputClass, tabName);
		return inputClass;
	}
	
	public ClassList getList(){
		return (ClassList) this.getSelectedComponent();
	}
	
}
