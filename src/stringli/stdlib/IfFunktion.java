package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.StringliException;
import stringli.ValueContainer;
import stringli.AST;
import stringli.AST.Argument;

public class IfFunktion implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		boolean a = Arguments.get(0).toBool();
		
		if(a)
		{
			AST code = Arguments.get(1).toInstructionList();
			for(Argument d:code.getChildren())
				e.run(d.arg);
		}	
		return null;
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return true;
	}

}
