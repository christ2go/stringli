package stringli;

public class BoolValueContainer extends ValueContainer {
	boolean val;
	public BoolValueContainer(boolean val)
	{
		this.val = val;
	}
	public double toNumber()
	{
		return val?1:0;
	}
	public boolean toBool()
	{
		return val;
	}
	public String toString()
	{
		if(val)
			return "#t";
		return "#f";
	}
}
