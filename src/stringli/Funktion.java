package stringli;
import java.util.ArrayList;

public interface Funktion {
	int params();
	ValueContainer run(Environment e,ArrayList<ValueContainer> Arguments) throws StringliException;
	boolean isMacro();
}