import java.awt.EventQueue;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	ArrayList<JButton[][]> listJB = new ArrayList<>();
	RubixCube r = new RubixCube();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.update();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton button_4 = new JButton("New button");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r.rotateCube(RotationMoves.R);
				update();
			}
		});

		listJB.add(create3x3(251, 25));
		listJB.add(create3x3(206, 70));
		listJB.add(create3x3(251, 70));
		listJB.add(create3x3(296, 70));
		listJB.add(create3x3(251, 115));
		listJB.add(create3x3(251, 160));
		r.createCube();

		button_4.setBounds(48, 235, 89, 15);
		frame.getContentPane().add(button_4);

		JButton btnR = new JButton("R");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.R);
				update();
			}
		});
		btnR.setBounds(0, 0, 89, 23);
		frame.getContentPane().add(btnR);

		JButton btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.L);
				update();
			}
		});
		btnL.setBounds(0, 111, 89, 23);
		frame.getContentPane().add(btnL);

		JButton btnU = new JButton("U");
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.U);
				update();
			}

		});
		btnU.setBounds(0, 21, 89, 23);
		frame.getContentPane().add(btnU);

		JButton btnM = new JButton("M");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.M);
				update();

			}
		});
		btnM.setBounds(0, 88, 89, 23);
		frame.getContentPane().add(btnM);

		JButton btnS = new JButton("S");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.S);
				update();
			}
		});
		btnS.setBounds(0, 45, 89, 23);
		frame.getContentPane().add(btnS);

		JButton btnU_1 = new JButton("U!");
		btnU_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.U1);
				update();
			}
		});
		btnU_1.setBounds(87, 21, 89, 23);
		frame.getContentPane().add(btnU_1);

		JButton btnR_1 = new JButton("R!");
		btnR_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.R1);
				update();
			}
		});
		btnR_1.setBounds(87, 0, 89, 23);
		frame.getContentPane().add(btnR_1);

		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.D);
				update();
			}
		});
		btnD.setBounds(0, 66, 89, 23);
		frame.getContentPane().add(btnD);

		JButton btnL_1 = new JButton("L!");
		btnL_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.L1);
				update();
			}
		});
		btnL_1.setBounds(87, 111, 89, 23);
		frame.getContentPane().add(btnL_1);

		JButton btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.F);
				update();
			}
		});
		btnF.setBounds(0, 134, 89, 23);
		frame.getContentPane().add(btnF);

		JButton btnF_1 = new JButton("F!");
		btnF_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.F1);
				update();
			}
		});
		btnF_1.setBounds(87, 134, 89, 23);
		frame.getContentPane().add(btnF_1);

		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.rotateCube(RotationMoves.B);
				update();
			}
		});
		btnB.setBounds(0, 156, 89, 23);
		frame.getContentPane().add(btnB);

		JButton btnB_1 = new JButton("B!");
		btnB_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r.rotateCube(RotationMoves.B1);
				update();
			}
		});
		btnB_1.setBounds(87, 156, 89, 23);
		frame.getContentPane().add(btnB_1);
		System.out.println("Test");
	}

	public JButton[][] create3x3(int x, int y) {
		JButton[][] bArray = new JButton[3][3];
		int tempY = y;
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			int tempX = x;
			for (int j = 0; j < 3; j++) {
				JButton b = new JButton();
				b.setBounds(tempX, tempY, 15, 15);
				bArray[i][j] = b;
				frame.getContentPane().add(b);
				tempX += 15;
			}
			tempY += 15;
		}
		return bArray;
	}

	public void update() {
		for (int i = 0; i < listJB.size(); i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					JButton[][] b = listJB.get(i);
					b[j][k].setBackground(r.cube[i][j][k].c);

				}
			}
		}
	}
}
