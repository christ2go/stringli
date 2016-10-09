package stringli;

public class StringValueContainer extends ValueContainer {
	String val;
	public StringValueContainer(String val)
	{
		this.val = val;
	}
	public double toNumber()
	{
		Double d = Double.parseDouble(val);
		return d;
	}
	public boolean toBool()
	{
		return this.equals("#t");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val;
	}
}
