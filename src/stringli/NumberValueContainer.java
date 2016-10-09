package stringli;

public class NumberValueContainer extends ValueContainer {
	double val;
	public NumberValueContainer(double val)
	{
		this.val = val;
	}
	public double toNumber()
	{
		return val;
	}
	public boolean toBool()
	{
		return val != 0.0;
	}
	public String toString()
	{
		return Double.toString(val);
	}
}
