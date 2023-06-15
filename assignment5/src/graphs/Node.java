package graphs;


/**
 
A binary tree node*
@author Jalal Kawash
*/
public class Node<T extends Comparable> {
    public static final boolean RED = false;
    public static final boolean BLACK = true;

    private T value;
    private Node<T> left, right, parent;
    private boolean color; 
    private Vertex vertex;
    private float weight;

    public Node(Vertex v, float weight) {
        left = null;
        right = null;
        parent = null;
        this.vertex = v;
        this.weight = weight;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft(){
        return left;
    }

    public void setLeft(Node<T> left){
        this.left = left;
    }

    public Node<T> getRight(){ 
        return right;
    }

    public void setRight(Node<T> right){
        this.right = right;
    }

    public Node<T> getParent(){ 
        return parent;
    }

    public void setParent(Node<T> parent){
        this.parent = parent;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String getRBTValue() { // for use with TreePrinter

        if (value != null) {
            String val = value.toString();
            if (color == RED) val+= "(r)";
            else val+= "(b)";
            return val;
        }
        return "";
    }
    public Vertex getVertex() {
        return vertex;
    }

    public Float getWeight() {
        return weight;
    }

}