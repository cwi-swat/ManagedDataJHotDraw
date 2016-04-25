package ccconcerns.managed_data.schemas;

import CH.ifa.draw.framework.*;
import CH.ifa.draw.framework.Painter;
import nl.cwi.managed_data_4j.language.primitives.Primitives;

import javax.swing.*;
import java.awt.*;

public interface JHotDrawPrimitives extends Primitives {
    JPanel JPanel();

    DrawingEditor DrawingEditor();
    Drawing Drawing();
    Painter Painter();
    PointConstrainer PointConstrainer();

    Color Color();
    Cursor Cursor();
    Point Point();
    Handle Handle();
    Figure Figure();
}
