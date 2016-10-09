package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.StringValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class Butfirst implements Funktion {

	@Override
	public int params() {
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		String s = Arguments.get(0).toString();
		String r = s.substring(1, s.length());
		return new StringValueContainer(r);
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
