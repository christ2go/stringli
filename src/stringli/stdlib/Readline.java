package stringli.stdlib;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import stringli.Environment;
import stringli.Funktion;
import stringli.StringValueContainer;
import stringli.StringliException;
import stringli.ValueContainer;

public class Readline implements Funktion {

	@Override
	public int params() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ValueContainer run(Environment e, ArrayList<ValueContainer> Arguments) throws StringliException {
		// TODO Auto-generated method stub
		System.out.println(Arguments.get(0).toString());
		Scanner s = new Scanner(e.source);
		return new StringValueContainer(s.nextLine());
	}

	@Override
	public boolean isMacro() {
		// TODO Auto-generated method stub
		return false;
	}

}
