package stringli.stdlib;

import java.util.ArrayList;

import stringli.Environment;
import stringli.Funktion;
import stringli.NumberValueContainer;
import stringli.ValueContainer;

public class sqrt implements Funktion {
	public int params()
	{
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) {
		// TODO Auto-generated method stub
		double number = Arguments.get(0).toNumber();
		return new NumberValueContainer(Math.sqrt(number));
	}
	
	public boolean isMacro()
	{
		return true;
	}
}