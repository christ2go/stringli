package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.ValueContainer;

/**
 * 
 * @author Christian Hagemeier
 *
 */
public class setVar implements Funktion {
	public int params()
	{
		return 2;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) {
		// TODO Auto-generated method stub
		e.setVariable(Arguments.get(0).toString(), Arguments.get(1));
		return null;
	}
	
	public boolean isMacro()
	{
		return true;
	}
}
