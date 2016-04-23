package ccconcerns.managed_data.primitives.jhodraw;

import CH.ifa.draw.framework.PointConstrainer;
import nl.cwi.managed_data_4j.language.primitives.AbstractPrimitive;

public class PointConstrainerPrimitive extends AbstractPrimitive {
    public PointConstrainerPrimitive() {
        super(null, PointConstrainer.class, "PointConstrainer",
                (o1, o2) -> Integer.compare(((PointConstrainer) o1).getStepX(), ((PointConstrainer)o2).getStepX()));
    }
}
