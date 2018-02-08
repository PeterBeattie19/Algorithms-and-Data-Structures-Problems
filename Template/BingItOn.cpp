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


void add( node* n, char* s, int index){
  
    if(*s){
    int i = *s - 'a'; 
    
    if(n->children[i] == NULL){
      n->children[i] = new node();
    }
    
    n->children[i]->count++; 
    return add(n->children[i], s+1, index+1); 
    }
    
    
      return; 
}


int findCount( node * n, char* s, int index){

    if(*s){
  int i = (*s - 'a');
  
  return findCount(n->children[i], s+1, index+1); 
    }
    
    
    return n->count; 
}

int main() {
   node* n = new node(); 
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

  int t;
  cin >> t; 

  for(int i = 0; i<t; i++){
    char * line = new char[32]; 

    cin >> line; 

    add(n, line, 0);

    printf("%d\n", findCount(n,line,0)-1);
}

  return 0; 
}
