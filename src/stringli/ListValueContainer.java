package stringli;

import java.util.ArrayList;

public class ListValueContainer extends ValueContainer {
	public ArrayList<ValueContainer> values;
	public ListValueContainer(ArrayList<ValueContainer> arg)
	{
		values = new ArrayList<ValueContainer>(arg);
	}
	
	@Override
	public String toString() {
		return values.toString();
	}

	@Override
	public double toNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean toBool() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ValueContainer last()
	{
		if(values.size() > 0)
			return values.get(values.size()-1);
		return null;
	}
	/**
	 * 
	 * @param index Index beginnend ab 1!
	 * @return
	 */
	public ValueContainer item(int index)
	{
		return values.get(index-1);
	}
	
	public boolean isList()
	{
		return true;
	}
	public int length()
	{
		return values.size();
	}
	
	public ListValueContainer append(ValueContainer v)
	{
		ArrayList<ValueContainer> n = new ArrayList<ValueContainer>(this.values);
		n.add(v);
		return new ListValueContainer(n);
	}
	
}
