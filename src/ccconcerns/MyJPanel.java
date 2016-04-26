package ccconcerns;

import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;

import javax.swing.*;
import java.awt.*;

/**
 * MDHD
 * Wrapper for JPanel, we need it for having access into the MDStandardDrawingView
 */
public class MyJPanel extends JPanel {
    private MDStandardDrawingView drawingView;

    public MDStandardDrawingView getDrawingView() {
        return drawingView;
    }

    public void setDrawingView(MDStandardDrawingView drawingView) {
        this.drawingView = drawingView;
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawingView.paintComponent(g);
    }
}
