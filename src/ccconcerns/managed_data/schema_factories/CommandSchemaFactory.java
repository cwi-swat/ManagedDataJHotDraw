package ccconcerns.managed_data.schema_factories;

import ccconcerns.managed_data.MDChangeAttrCmd;
import nl.cwi.managed_data_4j.IFactory;

public interface CommandSchemaFactory extends IFactory {
    MDChangeAttrCmd ChangeAttrCmd();
}
