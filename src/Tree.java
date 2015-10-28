
public class Tree {

	public Tree left;
	public Tree right;
	public int value;

    public boolean equals(Object o) {
    	if (o==null) {
    		return false;
    	}
    	if (!(o instanceof Tree)) {
    		return false;
    	}
    	if (this == o) {
    		return true;
    	}
    	if ( ((Tree)o).value != this.value ) {
    		return false;
    	} else if (this.left == ((Tree)o).left && this.right == ((Tree)o).right) {
			return true;
		} else if (this.left == ((Tree)o).left) {
			return (null!= this.right) && this.right.equals(((Tree)o).right);
		} else if (this.right == ((Tree)o).right) {
			return (null != this.left) && this.left.equals(((Tree)o).left);
		} else {
			return (null != this.left) && (null!= this.right) && this.left.equals(((Tree)o).left) && this.right.equals(((Tree)o).right);
		}
    }

    public static void main(String[] args) {
    	Tree t1 = new Tree();
    	t1.value = 1;
    	Tree t2 = new Tree();
    	t2.value = 1;

//    	t1.left = t2;

//    	Tree t3 = new Tree();
//    	t1.right = 
//    	t3.value = 3;
//    	Tree t4 = new Tree();
//    	t4.value = 4;
//    	Tree t5 = new Tree();
//    	t5.value = 5;

    	System.out.println(t1.equals(t2));
    	
    }
}
