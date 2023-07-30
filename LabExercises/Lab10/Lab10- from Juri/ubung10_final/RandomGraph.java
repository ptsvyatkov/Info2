package ubung10_final;

public class RandomGraph {
	public static void main(String[] args) {
		GraphWeighted graphWeighted = new GraphWeighted(false);
		int vertices = ((args.length == 0)?
							20 : Integer.parseInt(args[0]));
		int edges = ((args.length == 0)?
				100 : Integer.parseInt(args[1]));
		
		graphWeighted.RandomGraph(vertices, edges);
		
        graphWeighted.printEdges();
		for(int i = 0;i<10;i++) {
			VerticeWeighted randomV1 = graphWeighted.getRandomVertice();
			VerticeWeighted randomV2 = graphWeighted.getRandomVertice();
	        graphWeighted.DijkstraCheapestPath(randomV1, randomV2);
	        graphWeighted.resetVerticeVisited();
	        graphWeighted.DijkstraShortestPath(randomV1, randomV2);
	        graphWeighted.resetVerticeVisited();
	        System.out.println();
		}
	}
}
