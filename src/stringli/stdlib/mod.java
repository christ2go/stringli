package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.NumberValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class mod implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		return new NumberValueContainer(Arguments.get(0).toNumber()%Arguments.get(1).toNumber());

	}

	@Override
	public boolean isMacro() {
		return false;
	}

}
