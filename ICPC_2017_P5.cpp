#include <iostream>
#include <vector>
#include <array>
#include <string>

using namespace std; 

vector<vector<int>> graph(10001); 
vector<bool> visited(10001); 

void dfs(int n){
	if(graph[n].size() == 0){
	  if(visited[n] == false){
		  cout << n << " "; 
		  visited[n] = true; 
	  }
	}

	else{
		for(int i = 0; i<graph[n].size(); i++){
		  
			dfs(graph[n][i]);
		}
    if(visited[n] == false)
		  cout << n << " "; 
		  
		visited[n] = true; 
	}
}

int main(){
	
	int t;

	cin >> t; 
	

	while(t > 0){
		int n,m;
		int a,b;

		cin >> n >> m;


		for(int i = 0; i<m; i++){
			cin >> a >> b;

			graph[a].push_back(b); 
		}
    
    for(int i = 0; i<n; i++){
      dfs(i); 
    }

		cout << endl;
		t--; 

		graph.clear(); 
		visited.clear(); 

	}

	return 0; 
}


