package ccconcerns.managed_data.schemas.framework;

import ccconcerns.managed_data.schemas.framework.figures.MDFigure;
import ccconcerns.managed_data.schemas.framework.tools.MDTool;
import ccconcerns.managed_data.schemas.geometry.MDDimension;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;

import java.util.List;

public interface MDDrawingView {
    MDDrawingEditor editor(MDDrawingEditor... editor);
    MDTool tool(MDTool... tool);
    MDDrawing drawing(MDDrawing... drawing);

    MDDimension size(MDDimension... size);
    MDDimension minimumSize(MDDimension... minimumSize);
    MDDimension preferredSize(MDDimension... preferredSize);

    default void add(MDFigure figure) {
        drawing().add(figure);
    }

    default void remove(MDFigure figure) {
        drawing().remove(figure);
    }

    default void addAll(List<MDFigure> figures) {
        figures.forEach(this::add);
    }

    MDRectangle damage(MDRectangle... damage);
}
