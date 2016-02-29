package ie.gmit.sw;

public class RandomWalk {
	
	public RandomWalk(){
    	
        Maze maze = Maze.getInstance();
        Node start = maze.getStartNode();
        
        search(start, 100);
    }
	
	public void search(Node node, int iterations){
		int counter = 0;
		while(counter <= iterations){
			counter++;
			
			node.setVisited(true);
			System.out.println("Visiting " + node.getNodeName());
			
			if (node.isGoalNode()){
				System.out.println("Goal");
				return;
			}
			
			Node[] children = node.children();	
			int index = (int) new java.util.Random().nextInt(children.length);
			node = children[index];
		}
	}
	
	public static void main(String[] args) {
		new RandomWalk();
	}
}
