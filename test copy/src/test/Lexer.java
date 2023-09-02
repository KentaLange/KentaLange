package test;
import java.util.LinkedList;
import test.Token;
import test.Token.Type;

public class Lexer {
	//Access the class "StringHandler"
	StringHandler documentReader=new StringHandler("");
	Token tokens;//Access the class "Token"
	int lineNum;
	int index;
	Type myType;
	public Lexer(String input) {
		documentReader=new StringHandler(input);
		
	}
	public void Lex() {
		while(documentReader.isDone()==false) {
		//If the character is a space or tab, we will just move past it (increment position). 
		LinkedList<Token> characters = new LinkedList<Token>();
		if( documentReader.Peek(index)==' '){
			index++;
		}
		//If the character is (\n), we will create a new SEPERATOR token with no “value” and add it to token list.
		//Also increment the line number and set line position to 0.

		else
			if( documentReader.Peek(index)=='\n') {
			myType=Type.SEPARATOR;
			characters.add(new Token("",myType,lineNum,index));
			lineNum++;
			index=0;
			}
			//If the character is a letter, we need to call ProcessWord
			//and add the result to our list of tokens.

			else
				if( Character.isLetter(documentReader.Peek(index))) {
					characters.add(processWord());
			
				}
				//If the character is a digit, we need to call ProcessDigit 
				//and add the result to our list of tokens.
				else
					if( Character.isDigit(documentReader.Peek(index))) {
						characters.add(processNumber());
					}
		}
	}
	
	public Token processWord() {
		String words="";
		Token result;
		// Accepts letters, digits and underscores (_) and make a String of them. 
		//If not, end the loop and finish with Type WORD
		while(documentReader.Peek(index)=='_' || Character.isLetter(documentReader.Peek(index))
				|| Character.isDigit(documentReader.Peek(index))){
			words+=documentReader.PeekString(index);
			index++;
		}
		result=new Token(words,Type.WORD,lineNum,index);
		return result;
	}
	
	public Token processNumber() {
		String digits="";
		Token result;
		//Accepts only digits and one '.'
		//It does not accept + or -
		while((documentReader.Peek(index)=='.' && documentReader.Peek(index+1)!='.')
				|| Character.isDigit(documentReader.Peek(index))){
			digits+=documentReader.PeekString(index);
			index++;
		}
		result=new Token(digits,Type.NUMBER,lineNum,index);
		return result;
	}
}
