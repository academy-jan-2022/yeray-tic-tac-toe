package example;

public class Board {
        private String [][] myBoard = {
                {"_","_","_"},
                {"_","_","_"},
                {"_","_","_"},
        };

        public void setMyCell(String value, int x, int y) {
                this.myBoard[y][x] = value;
        }


        public String getMyCell(int x, int y) {
                return this.myBoard[y][x];
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
