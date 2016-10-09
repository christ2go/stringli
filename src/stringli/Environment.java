package stringli;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import stringli.AST.Argument;

public class Environment {
	HashMap<String,ValueContainer> values;
	HashMap<String,Funktion> funktionen;
	boolean returned = false;
	ValueContainer retVal;
	Environment parent = null;
	public InputStream source = System.in;
	
	public Environment()
	{
		values = new HashMap<String,ValueContainer>();
		funktionen =  new HashMap<String,Funktion>();
	}
	
	public Environment(Environment parent)
	{
		values = new HashMap<String,ValueContainer>();
		funktionen =  new HashMap<String,Funktion>();
		this.parent = parent;
	}
	
	public ValueContainer run(AST code) throws StringliException
	{
		// Kein Code kann ausgeführt werden, wenn schon etwas
		// zurückgegeben wurde
		if(returned)
			return null;
		if(code.type == ASTType.FUNCCALL)
		{
			if(code.funcname.equals("fn"))
			{
				String name = code.children.get(0).arg.funcname;
				ArrayList<String> arguments = new ArrayList<String>();
				for(Argument c:code.children.get(0).arg.children)
				{
					if(c.astarg || (!c.astarg && c.argT.Type != Tokens.IDENTIFIER))
						throw new StringliException("Parameter der Funktion müssen Identifier sein!");
					arguments.add(c.argT.value);
				}	
				AST instrl = new AST(ASTType.InstrList);
				for(int i = 1;i<code.children.size();i++)
				{
					Argument a = code.children.get(i);
					if(!a.astarg)
					{
						throw new StringliException("Funktionsdefinitionen müssen aus Funktonsaufrufen bestehen!");
					}	
					instrl.addChild(a);
				}	
				UserFunction f = new UserFunction(name,arguments,instrl);
				funktionen.put(name,f);
			}	
			else{
				// Existiert eine Funktion mit dem Namen
				Funktion f = findFunction(code.funcname);
				if(f == null)
				{
					throw new StringliException(String.format("Funktion %s nicht bekannt",code.funcname));
				}	
				// Argumentzahl korrekt?
				int argumente = code.children.size();
				if(argumente != f.params() && f.params() != -1)
				{	
					System.out.println(argumente);
					throw new StringliException(String.format("Falsche Funktionsargumentzahl für Funktion %s",code.funcname));
				}
				// Werte Argumente aus
				ArrayList<ValueContainer> Argumente = new ArrayList<ValueContainer>();
				for(Argument e:code.children)
				{
					// Werte das Argument aus
					if(e.astarg)
					{
						if(e.arg.type == ASTType.InstrList)
						{
							InstructionListContainer c = new InstructionListContainer(e.arg);
							Argumente.add(c);
						}else{
							ValueContainer t = run(e.arg);
							if(t == null)
							{
								throw new StringliException(String.format("Funktion hat nicht zurückgegben!",code.funcname));
							}	
							Argumente.add(t);
						}	
					}else{
						if(e.argT.Type == Tokens.IDENTIFIER)
						{
							// Variable finden
							ValueContainer val = getVariable(e.argT.value);
							if(val == null)
							{
								throw new StringliException(String.format("Variable nicht gesetzt!",e.argT.value));

							}	
							Argumente.add(val);
						}else if(e.argT.Type == Tokens.BOOLLIT)
						{
							BoolValueContainer bv = new BoolValueContainer(e.argT.num_val == 0.00);
							Argumente.add(bv);
						}else if(e.argT.Type == Tokens.NUMLIT)
						{
							NumberValueContainer nv = new NumberValueContainer(e.argT.num_val);
							Argumente.add(nv);
						}else if(e.argT.Type == Tokens.STRINGLIT)
						{
							StringValueContainer sv = new StringValueContainer(e.argT.value);
							Argumente.add(sv);
						}	
					}	
				}	
				Environment runenv;
				if(f.isMacro())
				{
					runenv = this;
				}else{
					runenv = new Environment(this);
				}	
				ValueContainer v = f.run(runenv, Argumente);
				if(returned)
					return retVal;
				if(v != null)
				{
					return v;
				}else{
					if(runenv.returned)
						return runenv.retVal;
				}
				return null;
			}
			// Gib am Ende das Resultat zurück
		}else if(code.type == ASTType.InstrList)
		{
			for(Argument e:code.children)
			{
				if(!returned)
				{
					if(e.astarg)
					{
						if(e.arg.type != ASTType.InstrList)
						{
							this.run(e.arg);
						}		
					}	
				}	
			}	
		}	
		return null;
	}
	
	private ValueContainer getVariable(String name)
	{
		if(this.values.containsKey(name))
			return values.get(name);
		if(parent != null)
			return parent.getVariable(name);
		return null;
	}
	
	public void setVariable(String name,ValueContainer val)
	{
		values.put(name, val);
	}
	
	private Funktion findFunction(String name)
	{
		if(this.funktionen.containsKey(name))
			return funktionen.get(name);
		if(parent != null)
			return parent.findFunction(name);
		return null;
	}

	public void ret(ValueContainer valueContainer) {
		// TODO Auto-generated method stub
		this.returned = true;
		this.retVal = valueContainer;
	}
}
