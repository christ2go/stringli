package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.StringliException;
import stringli.ValueContainer;

public class Run implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		e.run(Arguments.get(0).toInstructionList());
		return null;
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return true;
	}

}
