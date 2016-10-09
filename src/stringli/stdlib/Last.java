package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.ListValueContainer;
import stringli.StringValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class Last implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		if(Arguments.get(0).isList())
		{
			return ((ListValueContainer) Arguments.get(0)).last();
		}else{
			String s = Arguments.get(0).toString();
			return new StringValueContainer(Character.toString(s.charAt(s.length()-1)));
		}	
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
