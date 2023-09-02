package test;

public class Token {
	public enum Type{
		WORD,
		NUMBER,
		SEPARATOR
	}
	
	int index;
	String value;
	int lineNum;
	Type inputType;
	
	public Token(String document,Type file,int line, int location) {
		inputType=file;
		value=document;
		lineNum=line;
		index=location;
	}
	
	public Token(int line, int location, Type file) {
		lineNum=line;
		index=location;
	}
	
	public String toString() {
		String result="Line number" + lineNum +"\n Index" + index+"\n Document"
				+value +"\n Type" + inputType;
		
		return result;
	}
}
