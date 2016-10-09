package stringli;


public abstract class ValueContainer {
	enum types {
		str,nbr,bol,inlist
	}
	
	public abstract String toString();
	public abstract double toNumber();
	public abstract boolean toBool();
	public AST toInstructionList()
	{
		return null;
	}
	public boolean isInstructionList()
	{
		return false;
	}
	
	public boolean isList()
	{
		return false;
	}
	
}