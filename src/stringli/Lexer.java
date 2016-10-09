package stringli;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

enum Tokens {
	LPAREN,RPAREN,STRINGLIT,NUMLIT,BOOLLIT,
	VAR, IDENTIFIER
}
public class Lexer {
	BufferedReader reader;
	public class Token
	{
		
		Tokens Type;
		String value;
		double num_val;
		
		public Token(Tokens t,String val)
		{
			value = val;
			Type = t;
		}
		
		public Token(Tokens t,double val)
		{
			num_val = val;
			Type = t;
		}
		
		public String toString()
		{
			return String.format("%s %s", Type.toString(), value);
		}
		
	}
	
	public Lexer(String filename)
	{
		try {
			reader = new BufferedReader(new FileReader(filename));
			curr = (char) reader.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	char curr;
	private void readChar() throws IOException
	{
		curr = (char) reader.read();
	}
	public Token nextToken()
	{
		try {
			
			switch(curr)
			{
			case '(':
				readChar();
				return new Token(Tokens.LPAREN,"");
			case ')':
				readChar();
				return new Token(Tokens.RPAREN,"");
			case ';':
				
				while(reader.read() != '\n')
				{}
				readChar();
				return nextToken();
			case '#':
				readChar();
				if(curr == 't')
				{
					readChar();
					return new Token(Tokens.BOOLLIT,"true");
				}else{
					readChar();
					return new Token(Tokens.BOOLLIT,"false");
				}
			case ':':
				String varname = "";
				while(curr != ' ')
					curr = (char) reader.read();
					varname += curr;
				readChar();	
				return new Token(Tokens.VAR,varname);
			}
			if(Character.isDigit(curr))
			{
				
				String number = "";
				while(curr != ' ' &&( Character.isDigit(curr) || curr == '.'))
				{	
					number += curr;
					curr = (char) reader.read();
				}
				double val = Double.parseDouble(number);
				Token t = new Token(Tokens.NUMLIT,val);
				t.value = number;
				return t;
			}
			if(curr == '\"')
			{
				curr = (char) reader.read();;
				String stringlit = "";
				while(curr != '\"')
				{	
					stringlit += curr;
					curr = (char) reader.read();
				}
				readChar();
				return new Token(Tokens.STRINGLIT,stringlit);
			}
			if(Character.isAlphabetic(curr))
			{
				String name = "";
				while(Character.isAlphabetic(curr))
				{	
					name += curr;
					curr = (char) reader.read();
				}
				//readChar();
				return new Token(Tokens.IDENTIFIER,name);
			}	
			if(curr == '\t' || curr == '\n' || curr == ' ')
			{		
				readChar(); 
				return nextToken();
			}
			
		} catch (IOException e) {
			return null;
		}
		return null;
	}
}
