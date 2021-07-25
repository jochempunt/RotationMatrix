package net.codejava.swing;

import java.awt.Color;

public class controller {

	private windowApp GUI;

	private double[][] rM;

	private double alpha;

	private double beta;

	private double gamma;

	private double[][] aV;

	private double winkelDelta;

	public controller(windowApp pGui) {
		GUI = pGui;
	}

	public void setMatrixM(double[][] pmatrix) {
		rM = pmatrix;
		// matrixAusgabeD(rM);
		double[][] rMtemp = roundDoubleMatrix(rM, 3);
		double[][] z1 = { { rMtemp[0][0] - 1 }, { rMtemp[0][1] }, { rMtemp[0][2] } };

		double[][] z2 = { { rMtemp[1][0] }, { rMtemp[1][1] - 1 }, { rMtemp[1][2] } };

		double[][] z3 = { { rMtemp[2][0] }, { rMtemp[2][1] }, { rMtemp[2][2] - 1 } };

		aV = new double[3][1];

		if (!nullVektor(Kreuz(z1, z2))) {
			aV = Kreuz(z1, z2);
		} else if (!nullVektor(Kreuz(z2, z3))) {
			aV = Kreuz(z2, z3);
		} else if (!nullVektor(Kreuz(z3, z1))) {
			aV = Kreuz(z3, z1);
		}
		
		double[][] bV = keinVielfaches(aV);

		double[][] cV = Kreuz(bV, aV);
		double[][] cVStrich = null;

		try {
			cVStrich = matrixMultiplikationD(rM, cV);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(matrixAusgabeD(cVStrich));

		winkelDelta = winkel(cV, cVStrich);

		double[][] kreuzWinkel = Kreuz(cV, cVStrich);
		double vorzeichenProdukt = 0;

		try {
			vorzeichenProdukt = skalarProduktD(kreuzWinkel, aV);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// GUI.setLabel(matrixAusgabeD(z1));

		if (vorzeichenProdukt < 0) {
			winkelDelta = (-winkelDelta);
		}

		winkelDelta = Math.round(Math.toDegrees(winkelDelta));
		winkelDelta = Math.toRadians(winkelDelta);

		aV = normiere(aV);
		aV = roundDoubleVektor(aV, 3);

		GUI.setTextArea1(matrixAusgabeD(aV) + "\n" + Math.round(Math.toDegrees(winkelDelta)));

		// euler winkel:
		double[][] u = { { rM[0][0] }, { rM[1][0] }, { rM[2][0] } };
		double[][] v = { { rM[0][1] }, { rM[1][1] }, { rM[2][1] } };
		double[][] uStrich = { { rM[0][0] }, { rM[1][0] }, { 0 } };

		double[][] x = { { 1 }, { 0 }, { 0 } };
		double[][] y = { { 0 }, { 1 }, { 0 } };
		double[][] z = { { 0 }, { 0 }, { 1 } };
		double[][] k = Kreuz(z, u);

		alpha = 0;
		beta = 0;
		gamma = 0;

		// sonderfälle

		double[][] s1 = { { 0 }, { 0 }, { 1 } };
		double[][] s2 = { { 0 }, { 0 }, { -1 } };

		if (vergleicheVektor(u, s1)) {
			beta = Math.toRadians(-90);
			alpha = 0;
			gamma = winkel(y, v);
		} else if (vergleicheVektor(u, s2)) {
			beta = Math.toRadians(90);
			alpha = 0;
			gamma = winkel(y, v);
		} else {
			if (u[1][0] >= 0) {
				gamma = winkel(x, uStrich);

			} else {
				gamma = -winkel(x, uStrich);
			}

			if (u[2][0] >= 0) {
				beta = winkel(u, uStrich);
			} else {
				beta = -winkel(u, uStrich);
			}

			if (v[2][0] >= 0) {
				alpha = winkel(k, v);
			} else {
				alpha = -winkel(k, v);
			}

			alpha = Math.round(Math.toDegrees(alpha));
			alpha = Math.toRadians(alpha);

			beta = Math.round(Math.toDegrees(beta));
			beta = Math.toRadians(beta);

			gamma = Math.round(Math.toDegrees(gamma));
			gamma = Math.toRadians(gamma);

			
			
		}

		GUI.setTextArea2("D = D(z," + Math.round(Math.toDegrees(gamma)) + "°) o D(y," + Math.round(Math.toDegrees(beta))
				+ "°) o D(x," + Math.round(Math.toDegrees(alpha)) + "°)");

	}

	public double betrag(double[][] vektor) {
		double betrag = Math.sqrt(Math.pow(Math.abs(vektor[0][0]), 2) + Math.pow(Math.abs(vektor[1][0]), 2)
				+ Math.pow(Math.abs(vektor[2][0]), 2));
		return betrag;
	}

	public double winkel(double[][] p, double[][] q) {

		double skalarProdukt = skalarProduktD(p, q);

		double betragProdukt = betrag(p) * betrag(q);
		double skbtr = skalarProdukt / betragProdukt;
		if (betrag(Kreuz(p, q)) == 0 || betragProdukt == 0) {
			if (skbtr == 1) {
				return 0;
			} else if (skbtr == -1) {
				return Math.PI;
			}
		}

		return Math.acos(skbtr);
	}

	public double skalarProduktD(double[][] p, double[][] q) {
		return (p[0][0] * q[0][0]) + (p[1][0] * q[1][0]) + (p[2][0] * q[2][0]);
	}

	public boolean vergleicheVektor(double[][] a, double[][] b) {
		int gleichheit = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i][0] == b[i][0]) {
				gleichheit++;
			}
		}
		if (gleichheit == a.length) {
			return true;
		} else {
			return false;
		}
	}

	public boolean vergleicheMatrix(double[][] aM, double[][] bM) {
		int gleichheit = 0;

		for (int i = 0; i < aM.length; i++) {
			for (int j = 0; j < aM[0].length; j++) {
				if (aM[i][j] == bM[i][j]) {
					gleichheit++;
				}
			}
		}
		if (gleichheit == aM.length * aM[0].length) {
			return true;
		} else {
			return false;
		}

	}

	
	public double[][] keinVielfaches(double[][] vektor) {
		double[][] kv = new double[3][1];

		kv[0][0] = vektor[0][0] + 1;
		kv[1][0] = vektor[1][0] + 2;
		kv[2][0] = vektor[2][0] + 3;

		return kv;

	}

	public double[][] normiere(double[][] vektor) {
		double[][] normierterV = new double[3][1];

		double einDurchBetrag = 1 / betrag(vektor);
		for (int i = 0; i < vektor.length; i++) {
			normierterV[i][0] = einDurchBetrag * vektor[i][0];
		}

		return normierterV;
	}

	public boolean nullVektor(double[][] vektor) {
		if (betrag(vektor) == 0) {
			return true;
		} else {
			return false;
		}

	}

	public double[][] matrixMultiplikationD(double[][] matrixA, double[][] matrixB) throws Exception {
		double[][] ergebniss = null;

		if (matrixA[0].length == matrixB.length) {

			int zeilenMatrixA = matrixA.length;
			int spaltenMatrixA = matrixA[0].length;
			int spaltenMatrixB = matrixB[0].length;

			ergebniss = new double[zeilenMatrixA][spaltenMatrixB];

			for (int zeilenAE = 0; zeilenAE < zeilenMatrixA; zeilenAE++) {
				for (int spaltenBE = 0; spaltenBE < spaltenMatrixB; spaltenBE++) {
					ergebniss[zeilenAE][spaltenBE] = 0;
					for (int spaltenA_zeilenB = 0; spaltenA_zeilenB < spaltenMatrixA; spaltenA_zeilenB++) {
						ergebniss[zeilenAE][spaltenBE] += matrixA[zeilenAE][spaltenA_zeilenB]
								* matrixB[spaltenA_zeilenB][spaltenBE];
					}
				}
			}
			return ergebniss;
		} else {
			throw new Exception(
					"Anzahl Spalten der ersten Matrix muss gleich der Anzahl Zeilen der zweiten Matrix sein");
		}

	}

	public String matrixAusgabeD(double[][] matrix) {
		String ausgabe = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				ausgabe += matrix[i][j] + " ";
			}
			ausgabe += "\n";
		}

		return ausgabe;

	}

	public double[][] roundDoubleVektor(double[][] vektor, int nachkommastellen) {
		double x = Math.pow(10, nachkommastellen);
		for (int i = 0; i < vektor.length; i++) {
			vektor[i][0] = Math.round(vektor[i][0] * x) / x;
		}

		return vektor;

	}

	public double[][] roundDoubleMatrix(double[][] matrix, int nachkommastellen) {
		double x = Math.pow(10, nachkommastellen);
		for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[j][i] = Math.round(matrix[j][i] * x) / x;
			}
		}
		return matrix;

	}

	public boolean sindorthoGonal(double[][] a, double[][] b) {
		if (skalarProduktD(a, b) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean istRotationsMatrix(double[][] matrix) {
		double[][] tempM = roundDoubleMatrix(matrix, 2);
		double[][] u = { { tempM[0][0] }, { tempM[1][0] }, { tempM[2][0] } };
		double[][] v = { { tempM[0][1] }, { tempM[1][1] }, { tempM[2][1] } };
		double[][] w = { { tempM[0][2] }, { tempM[1][2] }, { tempM[2][2] } };

		if (sindorthoGonal(u, v) && sindorthoGonal(v, w) && sindorthoGonal(w, u)) {

			if (vergleicheVektor(roundDoubleVektor(Kreuz(u, v), 1), w)||(vergleicheVektor(roundDoubleVektor(Kreuz(v, u), 1), w))){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public double[][] Kreuz(double[][] a, double[][] b) {
		double[] ausgabe = new double[3];
		ausgabe[0] = a[1][0] * b[2][0] - a[2][0] * b[1][0];
		ausgabe[1] = a[2][0] * b[0][0] - a[0][0] * b[2][0];
		ausgabe[2] = a[0][0] * b[1][0] - a[1][0] * b[0][0];

		double matrixausgabe[][] = new double[3][1];

		for (int i = 0; i < ausgabe.length; i++) {
			matrixausgabe[i][0] = ausgabe[i];
		}

		return matrixausgabe;

	}

	public void validiere() {

		double a1 = aV[0][0];
		double a2 = aV[1][0];
		double a3 = aV[2][0];

		double[][] drehMatrix = {
				{ Math.pow(a1, 2.0) + Math.cos(winkelDelta) * (1 - Math.pow(a1, 2.0)),
						a1 * a2 * (1 - Math.cos(winkelDelta)) - a3 * Math.sin(winkelDelta),
						a1 * a3 * (1 - Math.cos(winkelDelta)) + a2 * Math.sin(winkelDelta) },
			    {		a1 * a2 * (1 - Math.cos(winkelDelta)) + a3 * Math.sin(winkelDelta),
						Math.pow(a2, 2.0) + Math.cos(winkelDelta) * (1 - Math.pow(a2, 2.0)),
						a2 * a3 * (1 - Math.cos(winkelDelta)) - a1 * Math.sin(winkelDelta) },
				{ 		a1 * a3 * (1 - Math.cos(winkelDelta)) - a2 * Math.sin(winkelDelta),
						a2 * a3 * (1 - Math.cos(winkelDelta)) + a1 * Math.sin(winkelDelta),
						Math.pow(a3, 2.0) + Math.cos(winkelDelta) * (1 - Math.pow(a3, 2.0)) } };

		drehMatrix = roundDoubleMatrix(drehMatrix, 2);
		double[][] rMTemp = roundDoubleMatrix(rM, 2);
		if (vergleicheMatrix(drehMatrix, rM)) {
			GUI.setColorT(Color.green.brighter());
			
		} else {
			GUI.setColorT(Color.red.brighter());
			
		}

		double[][] dZ = { { Math.cos(gamma), -Math.sin(gamma), 0 }, { Math.sin(gamma), Math.cos(gamma), 0 },
				{ 0, 0, 1 } };

		double[][] dY = { { Math.cos(beta), 0, Math.sin(beta) }, { 0, 1, 0 }, { -Math.sin(beta), 0, Math.cos(beta) } };

		double[][] dX = { { 1, 0, 0 }, { 0, Math.cos(alpha), -Math.sin(alpha) },
				{ 0, Math.sin(alpha), Math.cos(alpha) } };

		dX = roundDoubleMatrix(dX, 2);
		double[][] eulerDrehM = new double[3][1];
		try {
			eulerDrehM = matrixMultiplikationD(dZ, matrixMultiplikationD(dY, dX));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		eulerDrehM = roundDoubleMatrix(eulerDrehM, 2);
		GUI.setTextArea3(matrixAusgabeD(eulerDrehM));
		if (vergleicheMatrix(eulerDrehM, rMTemp)) {
			GUI.setColorT2(Color.green.brighter());
			
		} else {
			GUI.setColorT2(Color.red.brighter());
			
		}
		// validierung der euler winkel

		// code goes here

	}

}
