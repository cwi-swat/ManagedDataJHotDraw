package ccconcerns.managed_data.factories;

import CH.ifa.draw.framework.DrawingEditor;
import CH.ifa.draw.framework.FigureAttributeConstant;
import CH.ifa.draw.standard.AbstractCommand;
import ccconcerns.managed_data.MDChangeAttrCmd;
import ccconcerns.managed_data.schema_factories.CommandSchemaFactory;
import ccconcerns.managed_data.schemas.JHotDrawPrimitives;
import ccconcerns.undo.UndoableChangeAttrCmdDataManager;
import nl.cwi.managed_data_4j.framework.SchemaFactoryProvider;
import nl.cwi.managed_data_4j.language.data_manager.BasicDataManager;
import nl.cwi.managed_data_4j.language.schema.boot.SchemaFactory;
import nl.cwi.managed_data_4j.language.schema.load.SchemaLoader;
import nl.cwi.managed_data_4j.language.schema.models.definition.Schema;

public class MDCommandFactory {
    private static final Schema schemaSchema = SchemaFactoryProvider.getSchemaSchema();
    private static final SchemaFactory schemaFactory = SchemaFactoryProvider.getSchemaFactory();

    public static MDChangeAttrCmd newChangeAttrCommand(
            String name, FigureAttributeConstant attribute, Object value, DrawingEditor newDrawingEditor)
    {
        // ================================================
        final Schema cmdSchema = SchemaLoader.load(
                schemaFactory, schemaSchema,
                JHotDrawPrimitives.class, MDChangeAttrCmd.class);

        final BasicDataManager cmdDataMgr =
                new BasicDataManager(CommandSchemaFactory.class, cmdSchema);

        final CommandSchemaFactory cmdSchemaFactory = cmdDataMgr.make();
        // ================================================

        final MDChangeAttrCmd changeAttrCmd = cmdSchemaFactory.ChangeAttrCmd();
        changeAttrCmd.name(name);
        changeAttrCmd.attribute(attribute);
        changeAttrCmd.value(value);
        changeAttrCmd.drawingEditor(newDrawingEditor);
        changeAttrCmd.setEventDispatcher(new AbstractCommand.EventDispatcher(changeAttrCmd));
        changeAttrCmd.getDrawingEditor().addViewChangeListener(changeAttrCmd);

        return changeAttrCmd;
    }

    public static MDChangeAttrCmd newUndoableChangeAttrCommand(
            String name, FigureAttributeConstant attribute, Object value, DrawingEditor newDrawingEditor)
    {
        // ================================================
        final Schema cmdSchema = SchemaLoader.load(
                schemaFactory, schemaSchema,
                JHotDrawPrimitives.class, MDChangeAttrCmd.class);

        final UndoableChangeAttrCmdDataManager cmdDataMgr =
                new UndoableChangeAttrCmdDataManager(CommandSchemaFactory.class, cmdSchema);

        final CommandSchemaFactory cmdSchemaFactory = cmdDataMgr.make();
        // ================================================

        final MDChangeAttrCmd changeAttrCmd = cmdSchemaFactory.ChangeAttrCmd();
        changeAttrCmd.name(name);
        changeAttrCmd.attribute(attribute);
        changeAttrCmd.value(value);
        changeAttrCmd.drawingEditor(newDrawingEditor);
        changeAttrCmd.setEventDispatcher(new AbstractCommand.EventDispatcher(changeAttrCmd));
        changeAttrCmd.getDrawingEditor().addViewChangeListener(changeAttrCmd);

        return changeAttrCmd;
    }
}
