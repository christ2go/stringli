package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.NumberValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;
import stringli.ListValueContainer;
public class length implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		if(Arguments.get(0).isList())
			return new NumberValueContainer(((ListValueContainer)Arguments.get(0)).length());
		return new NumberValueContainer(Arguments.get(0).toString().length());
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
