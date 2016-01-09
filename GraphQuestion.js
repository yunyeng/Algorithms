var Queue = require('./LinkedQueue');
function Vertex(label){
	this.label = label;
	this.d = Number.POSITIVE_INFINITY;
	this.color = 0; // WHITE
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
	//this.adj[w].push(v);
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
	s.color = 1; // GRAY
	s.d = 0;
	var Q = new Queue();
	Q.enqueue(s);
	while(!Q.empty()){
		var u = Q.dequeue();
		//if(u == a) return true;
		for(var v in this.adj[u.label]){
				if(this.vertex[this.adj[u.label][v]].color == 0){ // WHITE
					this.vertex[this.adj[u.label][v]].color = 1; // GRAY
					this.vertex[this.adj[u.label][v]].d = u.d + 1;
					this.vertex[this.adj[u.label][v]].p = u;
					Q.enqueue(this.vertex[this.adj[u.label][v]]);
				}
		}
		u.color = 2; //BLACK
	}
	//return false;
}



var g = new Graph(5);
g.addEdge(0,1);
g.addEdge(0,2);
g.addEdge(1,3);
g.addEdge(2,4);

//var a = new Vertex(0);

//console.log(g.bfs(g.vertex[3], g.vertex[4]));

//console.log(g.vertex);

function printPath(s,v){
	if(v == s){
		console.log(s);
	} else if(v.p == null){
		console.log("no path");
	} else {
		printPath(s, v.p);
		console.log(v);
	}
}

//printPath(g.vertex[0], g.vertex[3])