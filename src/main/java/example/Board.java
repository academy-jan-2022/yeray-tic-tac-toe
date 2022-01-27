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
                return "";
        }
}
