class AVLTree{	
	 public class Node {    
	     Node left, right;
	     int data;
	     int height;
	 
	     /* Constructor */
	     public Node(){
	         left = null;
	         right = null;
	         data = 0;
	         height = 0;
	     }
	     /* Constructor */
	     public Node(int n){
	         left = null;
	         right = null;
	         data = n;
	         height = 0;
	     }     
	 }
	
     public Node root;     
 
     /* Constructor */
     public AVLTree(){
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty(){
         return root == null;
     }
     /* Make the tree logically empty */
     public void makeEmpty(){
         root = null;
     }
     /* Function to insert data */
     public void insert(int data){
         root = insert(data, root);
     }
     /* Function to get height of node */
     private int height(Node t ){
         return t == null ? -1 : t.height;
     }
     /* Function to max of left/right node */
     private int max(int lhs, int rhs){
         return lhs > rhs ? lhs : rhs;
     }
     /* Function to insert data recursively */
     private Node insert(int x, Node t){
         if (t == null){
             t = new Node(x);
         } else if (x < t.data){
             t.left = insert( x, t.left );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( x < t.left.data )
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
         } else if( x > t.data ) {
             t.right = insert( x, t.right );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( x > t.right.data)
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
         }
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
     /* Rotate binary tree node with left child */     
     private Node rotateWithLeftChild(Node k2){
         Node k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }
 
     /* Rotate binary tree node with right child */
     private Node rotateWithRightChild(Node k1){
         Node k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }
     /**
      * Double rotate binary tree node: first left child
      * with its right child; then node k3 with new left child */
     private Node doubleWithLeftChild(Node k3){
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }
     /**
      * Double rotate binary tree node: first right child
      * with its left child; then node k1 with new right child */      
     private Node doubleWithRightChild(Node k1){
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }    
     public int countNodes(Node r){
         if (r == null){
             return 0;
         } else {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     public boolean search(Node r, int val){
         boolean found = false;
         while ((r != null) && !found){
             int rval = r.data;
             if (val < rval){
                 r = r.left;
             } else if (val > rval){
                 r = r.right;
             } else {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     public void inorder(Node r){
         if (r != null){
             inorder(r.left);
             System.out.print(r.data +" ");
             inorder(r.right);
         }
     }
     public void preorder(Node r){
         if (r != null){
             System.out.print(r.data +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     public void postorder(Node r){
         if (r != null){
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.data +" ");
         }
     }     

	public static void main(String[] args){
		AVLTree avlt = new AVLTree(); 
		avlt.insert(1);
		avlt.insert(2);
		avlt.insert(3);
		avlt.insert(4);
		avlt.insert(5);
		avlt.insert(6);
		avlt.insert(7);
		avlt.insert(8);
		avlt.insert(9);
		avlt.insert(10);
		avlt.insert(11);
		
		//avlt.inorder();
		System.out.println(avlt.root.right.data);
	}

 }
 