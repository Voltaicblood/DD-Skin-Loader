package main;

import java.io.File;

public class FileArray{
	File[] array;
	int lastIndex;
	
	public FileArray(){
		array = new File[200];
		lastIndex = 0;
	}
	
	public int getLength(){
		return array.length;
	}
	
	public void addFile(File input){
		array[lastIndex] = input;
		lastIndex++;
	}
	
	public void removeFile(int index){
		try{
			if(index > this.getLength()){
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
