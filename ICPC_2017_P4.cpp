#include <bits/stdc++.h>

using namespace std; 

struct node{
  node * children[26];
  
  int count; 
  
  node(){
    count = 0;
    for(int i = 0; i<26; i++)
      children[i] = NULL; 
  }
};


void add( node* n, string s, int index){
  
    if(index < s.size()){
    int i = s[index] - 'a'; 
    
    if(n->children[i] == NULL){
      n->children[i] = new node();
    }
    
    n->children[i]->count++; 
    return add(n->children[i], s, index+1); 
    }
    
    
      return; 
}


int findCount( node * n, string s, int index){

    if(index < s.size()){
  int i = (s[index] - 'a');
  
  return findCount(n->children[i], s, index+1); 
    }
    
    
    return n->count; 
}

int main() {
   node* N = new node(); 

   //Fast input 
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

  int n,m;

  cin >> n >> m; 
  string line; 

  vector<string> prefix;

  for(int i = 0; i<n; i++){
    cin >> line;

    prefix.push_back(line);
  }


  for(int i = 0; i<m; i++){
    cin >> line; 

    add(N, line, 0);
  }


  

  for(int i = 0; i<n; i++){

    cout << findCount(N,prefix[i],0) << endl;
}

  return 0; 
}
