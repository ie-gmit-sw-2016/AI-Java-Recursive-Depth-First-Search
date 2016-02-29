package ie.gmit.sw;

public class RecursiveDFS {
	
	public RecursiveDFS(Maze maze) {
		search(maze.getStartNode());		
	}

	public void search(Node node){
		if (node.isGoalNode()){
			System.out.println("Reached goal node " + node.getNodeName());
			System.exit(0);
		}else{
			if (!node.isVisited()){
				node.setVisited(true);
				System.out.println("Visiting " + node.getNodeName());
				Node[] children = node.children();
				for (int i = 0; i < children.length; i++) {
					search(children[i]);
				}
			}else{
				System.out.println("\tIgnoring node " + node.getNodeName() + ". Already visited!");
			}
		}
	}

	public static void main(String[] args) {
		Maze maze = Maze.getInstance();
		RecursiveDFS search = new RecursiveDFS(maze);
	}
}
