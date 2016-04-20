package ccconcerns.managed_data.schemas.geometry;

import nl.cwi.managed_data_4j.language.schema.models.definition.M;

public interface MDPoint extends M {
    Integer x(Integer... x);
    Integer y(Integer... y);
}
