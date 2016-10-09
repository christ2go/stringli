package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.NumberValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class Add implements Funktion {

	@Override
	public int params() {
		return 2;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		return new NumberValueContainer(Arguments.get(0).toNumber()+Arguments.get(1).toNumber());
	}

	@Override
	public boolean isMacro() {
		return false;
	}

}
