package stringli.stdlib;

import java.util.ArrayList;

import stringli.BoolValueContainer;
import stringli.Environment;
import stringli.Funktion;
import stringli.StringliException;
import stringli.ValueContainer;

public class numberp implements Funktion {

	@Override
	public int params() {
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		try {
			Double d = Double.parseDouble(Arguments.get(0).toString());
			return new BoolValueContainer(true);
		} catch(NumberFormatException e1)
		{
			return new BoolValueContainer(false);
		}
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
