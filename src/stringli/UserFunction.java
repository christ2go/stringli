package stringli;
import java.util.ArrayList;

import stringli.AST.Argument;

public class UserFunction implements Funktion{
	public String name;
	public ArrayList<String> arguments;
	AST code;
	/**
	 * @param name
	 * @param arguments
	 * @param code
	 */
	public UserFunction(String name, ArrayList<String> arguments, AST code) {
		this.name = name;
		this.arguments = arguments;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getArguments() {
		return arguments;
	}
	public AST getCode() {
		return code;
	}
	@Override
	public int params() {
		return arguments.size();
	}
	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		for(int i = 0;i<params();i++)
		{
			e.setVariable(arguments.get(i), Arguments.get(i));
		}	
		for(Argument d:code.children)
			e.run(d.arg);
		return null;
	}
	
	public boolean isMacro()
	{
		return false;
	}
}
