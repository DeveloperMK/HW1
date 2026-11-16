
public class Assignment01Q05 {

    public static int findShortestPath(int[][] m, int i, int j) {
        int[] verticesToExplore = new int[m.length];
        boolean[] visited = new boolean[m.length];
        int[] distances = new int[m.length];
        int verticesCount = 0; // Next empty array position
        int currIdx = 0; // Next array position to explore

        if (i == j) {
            return 0;
        }

        verticesToExplore[verticesCount] = i;
        visited[i] = true;
        verticesCount++;

        while (currIdx < verticesCount) {
            int currVertex = verticesToExplore[currIdx];
            currIdx++;

            for (int neighbor = 0; neighbor < m.length; neighbor++) {
                if (m[currVertex][neighbor] == 1 && !visited[neighbor]) {
                    verticesToExplore[verticesCount] = neighbor;
                    visited[neighbor] = true;

                    distances[neighbor] = distances[currVertex] + 1;
                    if (neighbor == j) {
                        return distances[neighbor];
                    }

                    verticesCount++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][]{{0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {1, 0, 0, 0}}, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][]{{0, 1, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 1, 0}}, 0, 2)); // 2
    }
}
