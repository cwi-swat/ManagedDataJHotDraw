package ccconcerns.managed_data.schemas;

import nl.cwi.managed_data_4j.language.primitives.Primitives;

public interface JHotDrawPrimitives extends Primitives {
    javax.swing.JPanel JPanel();

    java.awt.Color Color();
    java.awt.Cursor Cursor();
    java.awt.Point Point();
    java.awt.Dimension Dimension();
    java.awt.Rectangle Rectangle();

    CH.ifa.draw.framework.DrawingEditor DrawingEditor();
    CH.ifa.draw.framework.Drawing Drawing();
    CH.ifa.draw.framework.Painter Painter();
    CH.ifa.draw.framework.PointConstrainer PointConstrainer();

    CH.ifa.draw.framework.Handle Handle();
    CH.ifa.draw.framework.Figure Figure();
}
