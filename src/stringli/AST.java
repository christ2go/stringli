package stringli;
import java.util.ArrayList;

enum ASTType {
	InstrList, FUNCCALL
}
public class AST {
	public static class Argument {
		Lexer.Token argT;
		public AST arg;
		boolean astarg = false;
		
		public Argument(AST t)
		{
			arg = t;
			astarg = true;
		}
		public Argument(Lexer.Token t)
		{
			argT = t;
			astarg = false;
		}
	}
	ASTType type;
	String funcname;
	ArrayList<Argument> children;
	public ArrayList<Argument> getChildren() {
		return children;
	}

	public AST(ASTType t)
	{
		type = t;
		children = new ArrayList<Argument>();
	}
	
	public void addChild(Argument child)
	{
		children.add(child);
	}
}
