package main;

import javax.swing.JTabbedPane;

public class ClassTabs extends JTabbedPane {
	
	ClassList[] classes;
	String[] className;
	int currentIndex = 0;
	
	public ClassTabs(){
		classes = new ClassList[20];
	}
	
	public void addTab(String tabName, String className){
		ClassList inputClass = new ClassList();
		add(inputClass, tabName);
		classes[currentIndex] = inputClass;
		this.className[currentIndex] = className;
		currentIndex++;
	}
	
	public ClassList getListCurrent(){
		return (ClassList) this.getSelectedComponent();
	}
	
	public ClassList getListAt(int index){
		return (ClassList) this.getComponentAt(index);
	}
	
	public boolean checkClasses(String className){
		int parseIndex = currentIndex - 1;
		while(parseIndex > -1){
			if (className.equalsIgnoreCase(this.className[parseIndex]))
				return true;
			parseIndex--;
		}
		return false;
	}
}
