# Game of Thrones Network - Data Structures and Algorithms Project

This project models the connections between the characters in the Game of Thrones TV series. The data are available [here](https://github.com/melaniewalsh/sample-social-network-datasets/blob/master/sample-).

## Project Description

The project uses a weighted graph to represent the connection strength among two individual characters in the series. The vertices of the graph are the series characters.

The project also includes a hashing technique to store strings as names in an array after generating a hashcode (index) for each name. The length of the hash table (array) is up to you, but do not choose it too big.

## Methods

The project includes the following methods:

- `ReadGraphFromFile()`: Loads graph data from a file into an adjacency matrix.
- `IsThereAPath(String name1, String name2)`: Returns true if there is a path between vertex name1 and name2 or false, otherwise.
- `AllPathsShorterThanEqualTo(int pathLen, int VertexNo, string name1)`: Prints all paths starting from vertex name1, shorter than or equal to the given path length, with at least VertexNo vertices.
- `ShortestPathLengthFromTo(String name1, String name2)`: Returns the length of shortest path from vertex name1 to vertex name2.
- `NoOfPathsFromTo(String name1, String name2)`: Returns the number of paths from name1 to name 2.
- `BFSfromTo(String name1, String name2)`: Prints the sequence of vertices while starting a BFS from name1 until reaching name2.
- `DFSfromTo(String name1, String name2)`: Prints the sequence of vertices while starting a DFS from name1 until reaching name2.
- `NoOfVerticesInComponent(String name1)`: Prints the number of vertices that exist in the component that contains name1.

## Note

In all the methods mentioned above, no vertex can be repeated in the same path.

## Usage

All methods mentioned above should be called one by one, and their input parameters should be received from the user interactively.

## License

This project is licensed under the terms of the MIT license.
