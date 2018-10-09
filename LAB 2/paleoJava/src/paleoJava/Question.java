package paleoJava;

public class Question extends Node {
	  private Node yes; // subtlety: shown as public member ends on the diagram
	  private Node no;
	  private boolean isInitial; // we still don't have a way to ensure there's just one initial node

	  public Node answer(boolean answer)
	  {
	    if(answer)
	    {
	      return yes; // NB this code(and my sequence diagram) assumes all the objects exist.
	                  // Or should yes actually be created here? Depends on UI issues we aren't going into, really.
	    }
	    else
	    {
	      return no;
	    }
	  }
	}