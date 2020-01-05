# Ex2-OOp
  Main purpose of the project is to:

1. Create directed weighted graph
1. Display the graph on graphic user interface ,
1. Run algorithms on the graph.

### How to use:
1. Create a new object from the class (this example with 6 vertex you can choose any number):
<graph g = new DGraph(6);>
or can add like that: <g.addNode(n)>//n is nodeData type
#### 2. connect with egdges:
`dg.connect(1,0 , 14);`
`dg.connect(0,1 , 14);`
`dg.connect(1,5 , 9);`
`dg.connect(1,2 , 7);`
`dg.connect(2,1 , 7);`
`dg.connect(2,5 , 10);`
`dg.connect(2,3 , 15);`
`dg.connect(3,2 , 15);`
`dg.connect(3,5 , 11);`
`dg.connect(3,4 , 6);`
`dg.connect(4,3 , 6);`
`dg.connect(4,0 , 9);`
`dg.connect(0,5 , 2);`
`dg.connect(0,4 , 9);`
`dg.connect(5, 0, 2);`
#### 3.creat new object from Graph_GUI class and init the graph into
`Graph_GUI window = new Graph_GUI(dg);`
# Example:
  <img width="658" alt="MagenDavid" src="https://user-images.githubusercontent.com/57963221/71644509-27296500-2cd2-11ea-8ab0-f1ba9f487e50.png">
