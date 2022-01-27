package example;

public class Board {
        private String [][] myBoard = {
                {"_","_","_"},
                {"_","_","_"},
                {"_","_","_"},
        };

        public boolean setMyCell(String value, int x, int y) {
                if(this.myBoard[y][x].equals("_")) {
                        this.myBoard[y][x] = value;
                        return true;
                }
                return false;
        }

        public String showBoard(){
                StringBuilder result = new StringBuilder();
                for (int i=0; i < myBoard.length; i++) {
                        result.append(String.join("|", myBoard[i]));
                        if (i < 2) {
                                result.append("\n");
                        }
                }
                return result.toString();
        }
}
