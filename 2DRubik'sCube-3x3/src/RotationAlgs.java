
public class RotationAlgs {
	public Piece[][][] selectAlg(RotationMoves move, Piece[][][] cube) {
		switch (move) {
		case U:
			cube = rotate_U(cube, 1);
			break;
		case U1:
			cube = rotate_U(cube, 3);
			break;
		case M:
			cube = rotate_M(cube, 3);
			break;
		case M1:
			cube = rotate_M(cube, 1);
			break;
		case R:
			cube = rotate_R(cube, 1);
			break;
		case R1:
			cube = rotate_R(cube, 3);
			break;
		case L:
			cube = rotate_L(cube, 3);
			break;
		case L1:
			cube = rotate_L(cube, 1);
			break;
		case F:
			cube = rotate_F(cube, 1);
			break;
		case F1:
			cube = rotate_F(cube, 3);
			break;
		case B:
			cube = rotate_B(cube, 1);
			break;
		case D:
			cube = rotate_D(cube, 1);
			break;
		case S:
			cube = rotate_S(cube, 1);
			break;
		default:
			break;
		}
		return cube;
	}

	public Piece[][][] rotate_M(Piece[][][] cube, int n) {
		Piece[] temp;
		for (int a = 0; a < n; a++) {
			for (int i = 2; i <= 6; i += 2) {
				if (i == 6) {
					i = 5;
				}
				temp = new Piece[] { cube[0][0][1], cube[0][1][1], cube[0][2][1] };
				for (int j = 0; j < 3; j++) {
					cube[0][j][1] = cube[i][j][1];
				}
				for (int j = 0; j < 3; j++) {
					cube[i][j][1] = temp[j];
				}
			}
		}
		return cube;
	}

	public Piece[][][] rotate_B(Piece[][][] cube, int n) {
		rotateSHorizontal(cube, 0, n);
		return cube;

	}

	public Piece[][][] rotate_S(Piece[][][] cube, int n) {
		rotateSHorizontal(cube, 1, n);
		return cube;

	}

	public Piece[][][] rotate_F(Piece[][][] cube, int n) {
		rotateSHorizontal(cube, 2, n);
		singleFaceURotation(cube, 4, n);
		return cube;

	}

	public Piece[][][] rotateSHorizontal(Piece[][][] cube, int strip, int n) {
		Piece[] temp;
		for (int a = 0; a < n; a++) {
			for (int i = 3; i > 0; i--) {
				temp = new Piece[] { cube[5][2-strip][0], cube[5][2-strip][1], cube[5][2-strip][2] };
				for (int j = 0; j < 3; j++) {
					cube[5][2-strip][j] = cube[i][strip][j];
				}
				for (int j = 0; j < 3; j++) {
					cube[i][strip][j] = temp[j];
				}
			}
		}
		return cube;

	}

	public Piece[][][] rotate_L(Piece[][][] cube, int n) {
		singleFaceSideRRotation(cube, 0, n);
		return cube;

	}

	public Piece[][][] rotate_R(Piece[][][] cube, int n) {
		singleFaceSideRRotation(cube, 2, n);
		return cube;

	}

	public Piece[][][] rotate_U(Piece[][][] cube, int n) {
		singleFaceURotation(cube, 5, n);
		singleFaceSideURotation(cube, 2, n);
		return cube;

	}

	public Piece[][][] rotate_D(Piece[][][] cube, int n) {
		singleFaceURotation(cube, 2, n);
		singleFaceSideURotation(cube, 0, n);
		return cube;

	}

	public Piece[][][] singleFaceSideRRotation(Piece[][][] cube, int face, int n) {
		Piece[] temp;
		Piece temp1;
		int face2 = face + 1;
		for (int a = 0; a < n; a++) {
			for (int i = 2; i <= 6; i += 2) {
				if (i == 6) {
					i = 5;
				}
				temp = new Piece[] { cube[0][0][face], cube[0][1][face], cube[0][2][face] };
				for (int j = 0; j < 3; j++) {
					cube[0][j][face] = cube[i][j][face];
				}
				for (int j = 0; j < 3; j++) {
					cube[i][j][face] = temp[j];
				}
			}
			for (int x = 0; x < 2; x++) {
				for (int i = 1; i >= 0; i--) {
					temp1 = cube[face2][0][2];
					cube[face2][0][2] = cube[face2][0][i];
					cube[face2][0][i] = temp1;
				}
				temp1 = cube[face2][0][2];
				cube[face2][0][2] = cube[face2][1][0];
				cube[face2][1][0] = temp1;
				for (int i = 0; i < 3; i++) {
					temp1 = cube[face2][0][2];
					cube[face2][0][2] = cube[face2][2][i];
					cube[face2][2][i] = temp1;
				}
				for (int i = 1; i > 0; i--) {
					temp1 = cube[face2][0][2];
					cube[face2][0][2] = cube[face2][i][2];
					cube[face2][i][2] = temp1;
				}
			}
		}
		return cube;
	}

	public Piece[][][] singleFaceSideURotation(Piece[][][] cube, int face, int n) {
		Piece[] temp1;
		int iFace = 2 - face;
		for (int a = 0; a < n; a++) {
			temp1 = new Piece[] { cube[4][face][0], cube[4][face][1], cube[4][face][2] };
			for (int j = 0; j < 3; j++) {
				cube[4][face][j] = cube[1][j][iFace];
			}
			for (int j = 0; j < 3; j++) {
				cube[1][j][iFace] = temp1[j];
			}
			temp1 = new Piece[] { cube[4][face][0], cube[4][face][1], cube[4][face][2] };
			for (int j = 0; j < 3; j++) {
				cube[4][face][j] = cube[0][iFace][2 - j];
			}
			for (int j = 0; j < 3; j++) {
				cube[0][iFace][2 - j] = temp1[j];
			}
			temp1 = new Piece[] { cube[4][face][0], cube[4][face][1], cube[4][face][2] };
			for (int j = 0; j < 3; j++) {
				cube[4][face][j] = cube[3][2 - j][face];
			}
			for (int j = 0; j < 3; j++) {
				cube[3][j][face] = temp1[2 - j];
			}
		}

		return cube;
	}

	public Piece[][][] singleFaceURotation(Piece[][][] cube, int face, int n) {
		Piece temp;
		for (int a = 0; a < n; a++) {
			for (int i = 0; i < 2; i++) {
				int counter = 0;
				int xC = 0;
				int yC = 2;
				boolean switchY = false;
				while (counter < 8) {
					temp = cube[face][0][2];
					cube[face][0][2] = cube[face][xC][yC];
					cube[face][xC][yC] = temp;
					if (yC < 3 && yC > 0 && !switchY) {
						yC--;
					} else if (yC == 0 && xC < 2) {
						xC++;
					} else if (xC == 2 && yC < 2) {
						switchY = true;
						yC++;
					} else {
						xC--;
					}
					System.out.println(xC + ", " + yC);
					counter++;
				}
			}
		}

		return cube;

	}

}
