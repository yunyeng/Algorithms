var Queue = require('./LinkedQueue');
function Vertex(label){
	this.label = label;
	this.d = Number.POSITIVE_INFINITY;
	this.color = 0; // WHITE
	this.p = null;
	this.f = Number.POSITIVE_INFINITY;
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
	this.dfs = dfs;
	this.dfsVisit = dfsVisit;
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
		for(var v in this.adj[u.label]){
			var a = this.vertex[this.adj[u.label][v]];
			//console.log(this.vertex[this.adj[u.label][v]]);
				if(a.color == 0){ // WHITE
					a.color = 1; // GRAY
					a.d = u.d + 1;
					a.p = u;
					Q.enqueue(this.vertex[this.adj[u.label][v]]);
				}
		}
		u.color = 2; //BLACK
	}
}

var time = 0;

function dfs(){
	for(var v=0; v<this.vertices; v++){
		//console.log(this.vertex[v]);
		if(this.vertex[v].color === 0){
			this.dfsVisit(this.vertex[v]);
		}
	}
}
function dfsVisit(u){
	time++;
	u.d = time;
	u.color = 1;
	for(var k in this.adj[u.label]){
		if(this.adj[u.label][k] != undefined){
			var v = this.vertex[this.adj[u.label][k]];
			console.log(v);
			if(v.color == 0){
				v.p = u;
				dfsVisit(v);
			}
		}
	}
	u.color = 2;
	time++;
	u.f = time;
}


var g = new Graph(5);
g.addEdge(0,1);
g.addEdge(0,2);
g.addEdge(1,3);
g.addEdge(2,4);


//var a = new Vertex(0);

//g.bfs();

//g.dfs();

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

module.exports = Graph;