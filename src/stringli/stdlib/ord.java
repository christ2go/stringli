package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.NumberValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class ord implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		if(Arguments.get(0).toString().length() != 1)
			throw new StringliRunTimeException("Ord kann nur auf Strings der Länge 1 arbeiten!");
		return new NumberValueContainer((int)Arguments.get(0).toString().charAt(0));
	}

	@Override
	public boolean isMacro() {
		return false;
	}

}
