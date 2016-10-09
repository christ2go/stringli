package stringli;

public class ASTPrinter {
	AST t;
	int indent;
	public ASTPrinter(AST t)
	{
		this(t,0);
	}
	
	public ASTPrinter(AST t,int indent)
	{
		this.t = t;
		this.indent = indent;
	}
	
	public void print()
	{
		for(int i=0;i<indent;i++)
			System.out.print("    ");
		System.out.print(t.type);
		System.out.print(" ");
		if(t.type == ASTType.FUNCCALL)
		{
			System.out.print(t.funcname);
		}	
		System.out.println(" ");
		for(AST.Argument a:t.children)
		{
			if(a.astarg)
			{
				ASTPrinter pri = new ASTPrinter(a.arg,indent+1);
				pri.print();
			}else{
				for(int i=0;i<(indent+1);i++)
					System.out.print("    ");
				System.out.println(a.argT);
			}	
		}	
	}
}
