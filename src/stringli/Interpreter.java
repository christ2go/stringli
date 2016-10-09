package stringli;

import stringli.AST.Argument;

public class Interpreter extends Environment {
	public Interpreter(AST code) throws StringliException
	{
		super();
		funktionen.put("sqrt", new stringli.stdlib.sqrt());
		funktionen.put("set", new stringli.stdlib.setVar());
		funktionen.put("print", new stringli.stdlib.Print());
		funktionen.put("readline", new stringli.stdlib.Readline());
		funktionen.put("return", new stringli.stdlib.Return());
		// Grundlegende Rechenarten
		funktionen.put("mult", new stringli.stdlib.Mult());
		funktionen.put("div", new stringli.stdlib.Div());
		funktionen.put("sub", new stringli.stdlib.sub());
		funktionen.put("add", new stringli.stdlib.Add());
		funktionen.put("mod", new stringli.stdlib.mod());
		// Stringfunktionen
		
		funktionen.put("item", new stringli.stdlib.Item());
		funktionen.put("it", new stringli.stdlib.Item());
		funktionen.put("bf", new stringli.stdlib.Butfirst());
		funktionen.put("butfirst", new stringli.stdlib.Butfirst());
		funktionen.put("butlast", new stringli.stdlib.Butlast());
		funktionen.put("bl", new stringli.stdlib.Butlast());
		funktionen.put("last", new stringli.stdlib.Last());
		funktionen.put("concat", new stringli.stdlib.Concat());
		// Character zu String und andersherum
		funktionen.put("ord", new stringli.stdlib.ord());
		funktionen.put("char", new stringli.stdlib.inttochar());
		funktionen.put("length", new stringli.stdlib.length());
		funktionen.put("list", new stringli.stdlib.List());
		// Kontrollflussfunktionen
		funktionen.put("if", new stringli.stdlib.IfFunktion());
		funktionen.put("ifelse", new stringli.stdlib.IfElseFunktion());
		funktionen.put("run", new stringli.stdlib.Run());
		
		// boolesche Prädikate
		funktionen.put("equalp", new stringli.stdlib.Equal());
		funktionen.put("not", new stringli.stdlib.Not());
		funktionen.put("and", new stringli.stdlib.And());
		funktionen.put("or", new stringli.stdlib.Or());
		funktionen.put("lessp", new stringli.stdlib.Lessp());
		funktionen.put("lesseqp", new stringli.stdlib.Lesseq());
		funktionen.put("greaterp", new stringli.stdlib.Greaterp());
		funktionen.put("greatereqp", new stringli.stdlib.Greatereqp());
		funktionen.put("numberp", new stringli.stdlib.numberp());
		
		funktionen.put("random", new stringli.stdlib.RandomNumber());
		funktionen.put("append", new stringli.stdlib.Append());
		for(Argument e:code.children)
			this.run(e.arg);
	}
}
