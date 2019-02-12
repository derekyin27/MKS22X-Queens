 public class QueenBoard{
  private int[][] board;


  public QueenBoard(int size){
    board = new int[size][size];
  }
  public String toString(){
    String str = "";
    for (int r =0; r < board.length; r++){
      for (int c = 0; c < board[0].length; c++){
        if (board[r][c] == -1){
          str+= "Q ";
        }
        else str+= "_ ";
      }
      str+="\n";
    }
    return str;
  }

  private void clear(){
    for (int r =0; r < board.length; r++){
      for (int c =0; c < board.length; c++){
        board[r][c] = 0;
      }
    }
  }

public String integersBoard(){
  String str = "";
  for (int r = 0; r < board.length; r++){
    for (int c =0; c < board[0].length; c++){
      str+= board[r][c];
    }
    str+="\n";
  }
  return str;
}
  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){
      return false;
    }
    else{
      for (int row = 0; row < board.length; row++){
        board[row][c]++;
      }
      for (int col = 0; col < board.length; col++){
        board[r][col]++;
      }
      for (int row = r, col = c; row < board.length && col < board.length; row++, col++){
      if (board[row][col] != -1)
      board[row][col]++;
    }
    for (int row = r, col = c; row >= 0 && col >= 0; row--, col--){
      if (board[row][col] != -1)
      board[row][col]++;
    }
    for (int row = r, col = c; row >= 0 && col < board.length; row--, col++){
      if (board[row][col] != -1)
       board[row][col]++;
    }
    for (int row = r, col = c; row < board.length && col >= 0; row++, col--){
      if (board[row][col] != -1)
      board[row][col]++;
    }
      board[r][c] = -1;
      return true;
    }

  }

  private boolean removeQueen(int r, int c){
    if (board[r][c] != -1){
      return false;
    }
    else{
      for (int row = 0; row < board.length; row++){
        board[row][c]--;
      }
      for (int col = 0; col < board.length; col++){
        board[r][col]--;
      }
      for (int row = r, col = c; row < board.length && col < board.length; row++, col++){
      if (board[row][col] != -1)
      board[row][col]--;
      }
      for (int row = r, col = c; row >= 0 && col >= 0; row--, col--){
      if (board[row][col] != -1)
      board[row][col]--;
      }
      for (int row = r, col = c; row >= 0 && col < board.length; row--, col++){
      if (board[row][col] != -1)
       board[row][col]--;
      }
      for (int row = r, col = c; row < board.length && col >= 0; row++, col--){
      if (board[row][col] != -1)
      board[row][col]--;
      }
      board[r][c] = 0;
      return true;
    }
  }

 public boolean solve(){
   for (int r = 0; r < board.length; r++){
     for (int c = 0; c < board.length; c++){
       if (board[r][c] != 0) throw new IllegalStateException();
     }
   }
   return solveH(0);
}

private boolean solveH(int c){
  if (c>=board.length){
    return true;
  }
  for (int r = 0; r < board.length; r++){
    if(addQueen(r,c)){
      if (solveH(c+1)){
        return true;
      }
      removeQueen(r, c);
    }
  }
  return false;
}

  public int countSolutions(){
    clear();
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c < board.length; c++){
        if (board[r][c] != 0) throw new IllegalStateException();
      }
    }
    return countH(0);
  }

  private int countH(int c){
    if (c >= board.length) return 1;
    int counter = 0;
    for (int r = 0; r < board.length; r++){
      if (addQueen(r, c)){
        counter += countH(c+1);
        removeQueen(r, c);
      }
    }
    return counter;
  }

public static void main(String[] args) {
  QueenBoard test = new QueenBoard(10);
  test.solve();
  System.out.print(test);
  System.out.println(test.countSolutions());
}
}
