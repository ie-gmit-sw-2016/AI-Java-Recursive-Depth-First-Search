package ie.gmit.sw;

import java.util.Deque;
import java.util.LinkedList;

public class BruteForceSearch{
    private Deque<Node> queue = new LinkedList<Node>();
    private boolean lifo;
    
    public BruteForceSearch(boolean lifo){
    	this.lifo = lifo;
        Maze maze = Maze.getInstance();
        queue.add(maze.getStartNode());
        search();
    }
    
    public void search(){
        
        while(!queue.isEmpty()){
        	System.out.println(queue);
           Node next = queue.poll();
        
            if (next != null){
                System.out.println("visited: " + next.getNodeName());
                next.setVisited(true);
                
                Node[] children = next.children();
                
                for (int i = 0; i < children.length; i++){
                    if (!children[i].isVisited()){
                    	if (lifo){
                    		queue.addFirst(children[i]);
                    	}else{
                    		queue.addLast(children[i]);
                    	}
                        
                    }
                }
            } 
        }
        
    }
    
    public static void main(String[] args){
        new BruteForceSearch(false);
    }
}