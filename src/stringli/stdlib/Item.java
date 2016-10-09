package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.ListValueContainer;
import stringli.StringValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class Item implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		if(Arguments.get(0).isList())
		{
			ListValueContainer v = (ListValueContainer) Arguments.get(0);
			return v.item((int) Arguments.get(1).toNumber());
		}	
		else
		{	
			String s = Arguments.get(0).toString();
			int index = (int) Arguments.get(1).toNumber()-1;
			return new StringValueContainer(Character.toString(s.charAt(index)));
		}
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
