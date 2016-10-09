package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.StringValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class inttochar implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		return new StringValueContainer(new String(Character.toString((char)(int)Arguments.get(0).toNumber())));
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
