package test;

public class StringHandler {
	private String documentHolder;
	private int index=0;
	
	public StringHandler(String document) {
		documentHolder=document;
		
	}
	
	public char Peek(int i) {
		return documentHolder.charAt(i);
	}
	
	public String PeekString(int i) {
		String result=Character.toString(documentHolder.charAt(i));
		return result;
	}
	
	public char getChar() {
		index ++;
		return documentHolder.charAt(index);
	}
	
	public void Swallow(char i) {
		for(int j=0;i<documentHolder.length();j++) {
			if(documentHolder.charAt(j)==i) {
				index=i;
			}
		}
	}
	
	public boolean isDone() {
		boolean result=false;
		if(documentHolder.length()<=index) {
			result=true;
		}
		return result;
	}
	
	public String remainder() {
		String result="";
		for(int i=index;i<documentHolder.length();i++) {
			result+=documentHolder.charAt(i);
		}
		return result;
	}
}
