package SpecifyDeep;

public class OuterClass implements Cloneable{

	public String name;
	public InnerClass child = new InnerClass();
	
	public class InnerClass implements Cloneable {
		public String getParent() {
			return name;
		}
		
		@Override
		public InnerClass clone() throws CloneNotSupportedException {
			return (InnerClass) super.clone();
		}
	}
	
	@Override
	public OuterClass clone() throws CloneNotSupportedException {
		OuterClass copy = (OuterClass) super.clone();
		copy.child = copy.child.clone();
		return copy;
	}
	

	public static void main(String[] args) throws CloneNotSupportedException {
		
		// Even when we use deep copy syntax it does NOT handle nested classes appropriately by default
		OuterClass original = new OuterClass();
		OuterClass copy = original.clone();
		original.name = "original";
		copy.name = "copy";
		
		System.out.println( "original.child.getParent() = " + original.child.getParent() );
		System.out.println( "copy.child.getParent() = " + copy.child.getParent() );

	}
	
}
