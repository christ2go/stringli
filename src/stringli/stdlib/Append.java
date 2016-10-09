package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.ListValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class Append implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		ListValueContainer liste = (ListValueContainer) Arguments.get(0);
		ValueContainer tap = Arguments.get(1);
			
		return liste.append(tap);
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
