package defaultClone;

public class OuterClass implements Cloneable{

	public String name;
	public InnerClass child = new InnerClass();
	
	public class InnerClass {
		public String getParent() {
			return name;
		}
	}
	
	@Override
	public OuterClass clone() throws CloneNotSupportedException {
		return (OuterClass) super.clone();
	}
	

	public static void main(String[] args) throws CloneNotSupportedException {
		
		// Show that clone does NOT handle nested classes appropriately by default
		OuterClass original = new OuterClass();
		OuterClass copy = original.clone();
		original.name = "original";
		copy.name = "copy";
		
		System.out.println( "original.child.getParent() = " + original.child.getParent() );
		System.out.println( "copy.child.getParent() = " + copy.child.getParent() );

	}
	
}
