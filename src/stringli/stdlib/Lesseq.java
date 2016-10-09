package stringli.stdlib;

import java.util.ArrayList;

import stringli.BoolValueContainer;
import stringli.Environment;
import stringli.Funktion;
import stringli.StringliException;
import stringli.ValueContainer;

public class Lesseq implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		return new BoolValueContainer(Arguments.get(0).toNumber() <= Arguments.get(1).toNumber());
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
