var Queue = require('./LinkedQueue');
function Vertex(label){
	this.label = label;
	this.d = Number.POSITIVE_INFINITY;
	this.color = "WHITE";
	this.p = null;
}
function Graph(v){
	this.vertices = v;
	this.edges = 0;
	this.adj = [];
	this.vertex = [];
	for(var i=0; i<this.vertices; i++){
		this.vertex.push(new Vertex(i));
		this.adj[i] = [];
	}
	this.addEdge = addEdge;
	this.bfs = bfs;
	this.show = show;
}
function addEdge(v,w){
	this.adj[v].push(w);
	this.adj[w].push(v);
	this.edges++;
}
function show(){
	var result = "";
	for (var i = 0; i < this.vertices; ++i){
		result += i + " -> "; 
		for (var j = 0; j < this.vertices; ++j){
			if (this.adj[i][j] != undefined) result += this.adj[i][j] + ' ';
		}
		result += '\n';
	}
	return result;
}
function bfs(){
	var s = this.vertex[0];
	s.color = "GRAY";
	s.d = 0;
	var Q = new Queue();
	Q.enqueue(s);
	while(!Q.empty()){
		var u = Q.dequeue();
		for(var v in this.adj[u.label]){
			//console.log(this.vertex[this.adj[u.label][v]]);
				if(this.vertex[this.adj[u.label][v]].color == "WHITE"){
					this.vertex[this.adj[u.label][v]].color = "GRAY";
					this.vertex[this.adj[u.label][v]].d = u.d + 1;
					this.vertex[this.adj[u.label][v]].p = u;
					Q.enqueue(this.vertex[this.adj[u.label][v]]);
				}
		}
		u.color = "BLACK";
	}
}



var g = new Graph(5);
g.addEdge(0,1);
g.addEdge(0,2);
g.addEdge(1,3);
g.addEdge(2,4);

//var a = new Vertex(0);

g.bfs();

console.log(g.vertex);