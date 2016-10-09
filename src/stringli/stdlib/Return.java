package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.StringliException;
import stringli.ValueContainer;

public class Return implements Funktion {

	@Override
	public int params() {
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		e.ret(Arguments.get(0));
		return null;
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return true;
	}

}
