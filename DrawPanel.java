package ru.vsu.cs.kg2020.g102.karaulova_n_a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

    private ScreenConverter sc = new ScreenConverter(-2, 2, 4, 4, 800, 600);

    public DrawPanel() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    private Line xAxis = new Line(-1, 0, 1, 0);
    private Line yAxis = new Line(0, -1, 0, 1);

    @Override
    public void paint(Graphics g) {
        sc.setsW(getWidth());
        sc.setsH(getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = bi.createGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0, getWidth(), getHeight());
        gr.dispose();
        gr = null;
        PixelDrawer pd = new BuffereImagePixelDrawer(bi);
        LineDrawer ld = new DDALineDrawer(pd);
        ld.drawLine(sc.r2s(xAxis.getP1()), sc.r2s(xAxis.getP2()));
        ld.drawLine(sc.r2s(yAxis.getP1()), sc.r2s(yAxis.getP2()));
        /**/
        /**/
        g.drawImage(bi, 0, 0, null);
    }

    private RealPoint oldPoint = null;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {


    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        oldPoint = sc.s2r(new ScreenPoint(mouseEvent.getX(), mouseEvent.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        oldPoint = null;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        RealPoint newPoint = sc.s2r(new ScreenPoint(mouseEvent.getX(), mouseEvent.getY()));
        if (oldPoint != null){
            double dx = newPoint.getX() - oldPoint.getX();
            double dy = newPoint.getY() - oldPoint.getY();
            sc.setrX(sc.getrX() - dx);
            sc.setrY(sc.getrY() - dy);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}

