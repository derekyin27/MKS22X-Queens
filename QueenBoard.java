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

  private boolean addQueen(int r, int c){
    if (r >= board.length || c >= board[0].length){
      return false;
    }
    
  }

  public boolean solve(){

  }

  public boolean countSolutions(){

  }

public static void main(String[] args) {
  QueenBoard test = new QueenBoard(10);
  System.out.println(test);
}
}
