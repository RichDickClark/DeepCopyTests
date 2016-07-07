package solution;

public class OuterClass implements Cloneable{

	public String name;
	public InnerClass child = new InnerClass();
	
	public final class InnerClass implements Cloneable {
		
		public InnerClass() {
		}
		
		/**
		 * Copy constructor
		 * @param orig
		 */
		public InnerClass( InnerClass orig ) {
			this.value = orig.value;
		}
		
		public String getParent() {
			return name;
		}
		
		public int value = 0;
		
		@Override
		public InnerClass clone() throws CloneNotSupportedException {
			return (InnerClass) super.clone();
		}
	}
	
	@Override
	public OuterClass clone() throws CloneNotSupportedException {
		OuterClass copy = (OuterClass) super.clone();
		copy.cloneChildren();
		return copy;
	}
	
	public void cloneChildren() throws CloneNotSupportedException {
		child = new InnerClass( this.child );
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		
		// This works as long as the inner class isn't going to overridden
		OuterClass original = new OuterClass();
		original.child.value = 42;
		OuterClass copy = original.clone();
		original.name = "original";
		copy.name = "copy";
		
		System.out.println( "original.child.getParent() = " + original.child.getParent() );
		System.out.println( "original.child.value = " + Integer.toString(original.child.value) );
		System.out.println( "copy.child.getParent() = " + copy.child.getParent() );
		System.out.println( "copy.child.value = " + Integer.toString(copy.child.value) );

	}
	
}
