package stringli;

class InstructionListContainer extends ValueContainer {
	AST t;
	public InstructionListContainer(AST x)
	{
		t = x;
	}
	@Override
	public String toString() {
		
		return null;
	}

	@Override
	public double toNumber() {
		
		return 0;
	}

	@Override
	public boolean toBool() {
		
		return false;
	}
	
	public AST toInstructionList()
	{
		return t;
	}
	public boolean isInstructionList()
	{
		return true;
	}
	
}
