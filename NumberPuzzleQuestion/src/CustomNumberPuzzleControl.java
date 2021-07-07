import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		//Your logic here
		for(int i=0; i<=15;i++)
		{
			if (buttonClicked == buttons[i])
			{
				System.out.print("Hello"+ emptyCellId + i);
				if(
						(
								(java. lang. Math. abs((i/4)-(emptyCellId/4))==1) && 
								(java. lang. Math. abs((i%4)-(emptyCellId%4))==0)
						)
						||
						(
								(java. lang. Math. abs((i/4) - (emptyCellId/4)) == 0) && 
								
								(java. lang. Math. abs((i%4)- (emptyCellId%4)) == 1))
						)
				{
					swapButton(buttons[emptyCellId], buttonClicked);
					emptyCellId = i;
					break;
				}

			}
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		//Your logic here
		java.util.Set<Integer> set = new java.util.HashSet<Integer>();
		int a = getRandomNumber();
		set.add(a%15 + 1);
		arr[0] = a%15+1;
		for(int i=1;i<15; i++)
		{
			a = getRandomNumber();
			while(set.contains(a%15+1))
			{
				a = getRandomNumber();
				
			}
			set.add(a%15+1);
			arr[i] = a%15+1;			
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		 int [] NumArray = getIntegerArrayOfButtonIds(buttons);
		 for (int i=0; i<14; i++)
		 {
			if (NumArray[i] > NumArray[i+1])
			{
				winner = false;
				break;
			}
		 }
		return winner;
	}
}