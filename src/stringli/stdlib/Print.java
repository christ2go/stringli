package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.ValueContainer;

public class Print implements Funktion {
	public int params()
	{
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) {
		// TODO Auto-generated method stub
		System.out.println(Arguments.get(0).toString());
		return null;
	}
	
	public boolean isMacro()
	{
		return true;
	}
}
