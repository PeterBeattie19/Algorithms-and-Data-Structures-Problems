board = list(range(2, 101)) 

def solve(n, pos):
    if n == 1:
        return True
    if pos == -1:
        return False 
    
    if n%board[pos] == 0 and board[pos] != -1:
        n /= board[pos] 
        board[pos] = -1 

    return solve(n, pos-1) 


x, y = map(int, input().split()) 
x = min(x,y) ; y = max(x,y) 

x_bool = solve(x, len(board) - 1) 

if not x_bool: 
    board = list(range(2, 101)) 

y_bool = solve(y, len(board)-1) 

if x_bool and y_bool:
    print(y) 
elif x_bool:
    print(x) 
elif y_bool:
    print(y) 
else:
    print(y) 