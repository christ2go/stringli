package stringli.stdlib;

import java.util.ArrayList;

import stringli.BoolValueContainer;
import stringli.Environment;
import stringli.Funktion;
import stringli.StringliException;
import stringli.ValueContainer;

public class Equal implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		ValueContainer a = Arguments.get(0);
		ValueContainer b = Arguments.get(1);
		return new BoolValueContainer(a.toString().equals(b.toString()));
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return true;
	}

}
