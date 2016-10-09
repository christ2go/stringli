package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.StringliException;
import stringli.ValueContainer;
import stringli.AST;
import stringli.AST.Argument;

public class IfElseFunktion implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		boolean a = Arguments.get(0).toBool();
		AST code = null;
		
		if(a)
		{
			code = Arguments.get(1).toInstructionList();
		}else{
			code = Arguments.get(2).toInstructionList();
		}	
		if(code == null)
			throw new StringliRunTimeException("Wrong types for if!");
		for(Argument d:code.getChildren())
			e.run(d.arg);
		return null;
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return true;
	}

}
