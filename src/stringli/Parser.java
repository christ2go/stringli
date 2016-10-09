package stringli;
import java.util.ArrayList;




public class Parser {
	ArrayList<Lexer.Token> tokens;
	Lexer.Token currT;
	public Parser(ArrayList<Lexer.Token> stream)
	{
		tokens = stream;
	}
	
	boolean nextToken()
	{
		if(tokens.size() != 0)
		{
			currT = tokens.remove(0);
			return true;
		}	
		return false;
	}
	
	boolean hasNextToken()
	{
		return 0 != tokens.size();
	}
	
	AST parseMain()
	{
		AST t = new AST(ASTType.InstrList);
		nextToken();
		while(hasNextToken())
		{
			System.out.println("Adding aregument");
			System.out.println(currT);
			t.addChild(new AST.Argument(parseParen()));
		}	
		return t;
	}
	
	AST parseParen()
	{
		if(currT.Type != Tokens.LPAREN)
		{
			System.out.println("Exspected (");
			System.out.println(currT.toString());
			System.exit(2);
		}else{
			nextToken();
		}	
		// Identifier => Functioncall 
		if(currT.Type == Tokens.IDENTIFIER)
		{
			AST t = new AST(ASTType.FUNCCALL);
			t.funcname = currT.value;
			nextToken();
			while(currT.Type != Tokens.RPAREN)
			{
				t.addChild(parseArgument());
			}
			if(currT.Type != Tokens.RPAREN)
			{
				System.out.println("Fehler: Erwartete )");
				System.exit(2);
			}	
			nextToken();
			return t;
		}	
		// LPAREN => Instr-List
		else if(currT.Type == Tokens.LPAREN)
		{
			AST t = new AST(ASTType.InstrList);
			while(currT.Type != Tokens.RPAREN)
			{
				t.addChild(new AST.Argument(parseParen()));
			}
			if(currT.Type != Tokens.RPAREN)
			{
				System.out.println("Fehler: Erwartete )");
				System.exit(2);
			}	
			nextToken();
			return t;
		}
		return null;
		
	}
	
	public AST.Argument parseArgument()
	{
		if(currT.Type == Tokens.LPAREN)
		{
			return new AST.Argument(parseParen());
		}	
		else if(currT.Type == Tokens.STRINGLIT ||
				currT.Type == Tokens.NUMLIT ||
				currT.Type == Tokens.IDENTIFIER ||
				currT.Type == Tokens.VAR || currT.Type == Tokens.BOOLLIT)
		{
			
			AST.Argument retVal =  new AST.Argument(currT);
			nextToken();
			return retVal;
		}	
		return null;
			
	}
}
