package slide3;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CvDefPoly extends Canvas {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<Point2d> v = new Vector<Point2d>();
	 float x0, y0, rWidth = 10.0F, rHeight = 7.5F, pixelSize;
	 boolean ready = true;
	 int centerX, centerY;
	 
	 CvDefPoly() {
		 addMouseListener(new MouseAdapter() { // ATIVANDO O MOUSE
			 public void mousePressed(MouseEvent evt) { 
				float xA = fx(evt.getX()), yA = fy(evt.getY()); // COORDENADAS X E Y DE ONDE O MOUSE FOI PRESSIONADO

				if (ready) {
					v.removeAllElements(); // ESVAZIANDO O SETOR DE VERTICES
					x0 = xA;
					y0 = yA;
					ready = false;
				}
				float dx = xA - x0, dy = yA - y0;
				if (v.size() > 0 && dx * dx + dy * dy < 4 * pixelSize * pixelSize) //VERTICE DENTRO DO PEQUENO RETANGULO
					ready = true;
				else
					v.addElement(new Point2d(xA, yA)); // ARMAZENA O VERTICE NO VETOR
				repaint();

			 }
		 });
	 }

	void initgr() { //DIMENSAO DO RETANGULO
		Dimension d = getSize();
		int maxX = d.width - 1, maxY = d.height - 1;
		pixelSize = Math.max(rWidth/maxX, rHeight/maxY);
		centerX = maxX/2;
		centerY = maxY/2;
	}
	
	int iX(float x) {
		return Math.round(centerX + x/pixelSize);
	}
	
	int iY(float y) {
		return Math.round(centerY - y/pixelSize);
	}
	
	float fx(int x) {
		return (x - centerX) * pixelSize;
	}
	
	float fy(int y) {
		return (centerY - y) * pixelSize;
	}
	

	public void paint(Graphics g) {
		initgr();
		int left = iX(-rWidth/2), right = iX(rWidth/2), bottom = iY(-rHeight/2), top = iY(rHeight/2);
		g.drawRect(left, top, right - left, bottom - top); //DESENHA O RETANGULO
		int n = v.size();
		if (n == 0) return;
	
		Point2d a = (Point2d)(v.elementAt (0)); //PRIMEIRO VERTICE
		// Mostra um pequeno retângulo em torno do primeiro vértice:
		g.drawRect(iX(a.x)-2, iY(a.y)-2, 4, 4); //DESENHA O PEQUENO RETANGULO
		for (int i=1; i<=n; i++) {
			if (i == n && !ready) break;
			Point2d b = (Point2d)(v.elementAt(i % n));
			g.drawLine(iX(a.x), iY(a.y), iX(b.x), iY(b.y)); //DESENNHA O SEGMENTO DE RETA ENTRE CADA 2 VERTICES CONSECUTIVOS
			a = b;
		}	
		
	}

}