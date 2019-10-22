import java.awt.Color;

public class RubixCube {
	Piece[][][] cube = new Piece[6][3][3];
	RotationAlgs rAlgs = new RotationAlgs();
	Color[] colours = new Color[] { Color.GREEN, new Color(0xff8100), Color.WHITE, Color.RED, Color.BLUE,
			Color.YELLOW };

	public int createCube() {
		for (int i = 0; i < colours.length; i++) {
			for (int j = 0; j < cube[0].length; j++) {
				for (int k = 0; k < cube[0][0].length; k++) {
					cube[i][j][k] = new Piece(colours[i]);
				}
			}
		}
		// cube[1][0][0].c = Color.BLACK;
		// cube[3][0][2].c = Color.BLACK;
		// cube[4][0][2].c = Color.BLACK;
		cube[4][2][0].c = Color.BLACK;
		// cube[5][2][0].c = Color.RED;
		// cube[5][2][2].c = Color.GREEN;
		return 0;
	}

	public void scrambleCube() {

	}

	public void rotateCube(RotationMoves rm) {
		cube = rAlgs.selectAlg(rm, cube);
	}

	public void displayCube() {
		for (int i = 0; i < colours.length; i++) {
			for (int j = 0; j < cube[0].length; j++) {
				for (int k = 0; k < cube[0][0].length; k++) {
					System.out.print(cube[i][j][k].c);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
