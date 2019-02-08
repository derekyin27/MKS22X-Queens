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
    if (r >= board.length || c >= board[0].length || c < 0 || r < 0){
      throw new IndexOutOfBoundsException();
    }
    if (board[r][c] != 0){
      return false;
    }
    else{
      for (int row = 0; row < board.length; row++){
        board[row][c] = 1;
      }
      for (int col =0; col <board[0].length; col++){
        board[r][col] = 1;
      }
      //for (int row = )
      board[r][c] = -1;
      return true;
    }

  }

//  public boolean solve(){

//  }

//  public boolean countSolutions(){

//  }

public static void main(String[] args) {
  QueenBoard test = new QueenBoard(10);
  test.addQueen(1, 5);
  System.out.println(test);
  System.out.println(test.integersBoard());
}
}
