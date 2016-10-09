package stringli;
import java.util.ArrayList;

/**
 * @author christian
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lexer l = new Lexer(args[0]);
		Lexer.Token nextToken;
		ArrayList<Lexer.Token> list = new ArrayList<Lexer.Token>();
		while((nextToken = l.nextToken()) != null)
		{
			list.add(nextToken);
			System.out.println(nextToken);
		}	
		Parser p = new Parser(list);
		AST a = p.parseMain();
		ASTPrinter pri = new ASTPrinter(a);
		pri.print();
		try {
			Interpreter i = new Interpreter(a);
		} catch (StringliException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
