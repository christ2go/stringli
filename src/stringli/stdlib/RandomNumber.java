package stringli.stdlib;

import java.util.ArrayList;
import java.util.Random;

import stringli.Environment;
import stringli.Funktion;
import stringli.NumberValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class RandomNumber implements Funktion {
	Random r = new Random();
	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		int lower = (int) Arguments.get(0).toNumber();
		int upper = (int) Arguments.get(1).toNumber();
		return new NumberValueContainer(r.nextInt(upper-lower)+lower);
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
