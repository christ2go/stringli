package stringli.stdlib;

import java.util.ArrayList;

import stringli.BoolValueContainer;
import stringli.Environment;
import stringli.Funktion;
import stringli.StringliException;
import stringli.ValueContainer;

public class Not implements Funktion {

	@Override
	public int params() {
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		return new BoolValueContainer(!Arguments.get(0).toBool());
	}

	@Override
	public boolean isMacro() {
		return false;
	}

}
