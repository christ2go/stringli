package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.ListValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class List implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		ListValueContainer l = new ListValueContainer(new ArrayList<ValueContainer>(Arguments));
		return l;
		
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
