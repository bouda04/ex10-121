
public class Game {

	public static void main(String[] args) {
		final int PLAYERS = 5;
		int[] board = {0, -1, 1, 2, 3, -1, 1, 5, -1, 1, 0, 4, 1, 6, 0, 1, 0, 1, 0, -1};
		Digger[] diggers = new Digger[PLAYERS];
		int[] positions = {3, 4, 11, 7, 13};
		for (int i=0; i<diggers.length;i++)
			diggers[i] = new Digger(i+2);
		int cnt=PLAYERS;
		int turn=0;
		while (cnt>1) {
			Digger currentPlayer = diggers[turn];
			if (currentPlayer.getDiamonds()!=0) {
				int nextMove = currentPlayer.draw();
				int currentPosition = positions[turn];
				int newPosition = (currentPosition + nextMove)% board.length;
				if (board[newPosition]==1)
					currentPlayer.add();
				else if (board[newPosition]==-1)
					currentPlayer.lose();
				else if (board[newPosition]>1) {
					Digger enemy = diggers[board[newPosition]-2];
					currentPlayer.eat(enemy);
					cnt--;
				}
				System.out.println(currentPlayer);
				positions[turn] = newPosition;
				board[newPosition] = board[currentPosition];
				board[currentPosition]=0;
			}
			turn = (turn + 1) % PLAYERS;
		}
		
		for (int i=0; i<PLAYERS;i++) {
			if (diggers[i].getDiamonds() >0)
				System.out.println("The winner is .........: " + diggers[i]);
		}
	}

}
