/*
 * This file is generated by jOOQ.
 */
package com.pdmweb.base.jooq.tables.records;


import com.pdmweb.base.jooq.tables.PdmTableField;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PdmTableFieldRecord extends UpdatableRecordImpl<PdmTableFieldRecord> implements Record8<Object, String, String, Integer, String, String, String, Object> {

    private static final long serialVersionUID = -800256283;

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public void setFieldId(Object value) {
        set(0, value);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public Object getFieldId() {
        return get(0);
    }

    /**
     * Setter for <code>pdm_table_field.field_code</code>.
     */
    public void setFieldCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pdm_table_field.field_code</code>.
     */
    public String getFieldCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>pdm_table_field.field_type</code>.
     */
    public void setFieldType(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>pdm_table_field.field_type</code>.
     */
    public String getFieldType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>pdm_table_field.field_size</code>.
     */
    public void setFieldSize(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>pdm_table_field.field_size</code>.
     */
    public Integer getFieldSize() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>pdm_table_field.field_primary</code>.
     */
    public void setFieldPrimary(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>pdm_table_field.field_primary</code>.
     */
    public String getFieldPrimary() {
        return (String) get(4);
    }

    /**
     * Setter for <code>pdm_table_field.field_isnull</code>.
     */
    public void setFieldIsnull(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>pdm_table_field.field_isnull</code>.
     */
    public String getFieldIsnull() {
        return (String) get(5);
    }

    /**
     * Setter for <code>pdm_table_field.field_desc</code>.
     */
    public void setFieldDesc(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>pdm_table_field.field_desc</code>.
     */
    public String getFieldDesc() {
        return (String) get(6);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public void setTableId(Object value) {
        set(7, value);
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public Object getTableId() {
        return get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Object> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Object, String, String, Integer, String, String, String, Object> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Object, String, String, Integer, String, String, String, Object> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public Field<Object> field1() {
        return PdmTableField.PDM_TABLE_FIELD.FIELD_ID;
    }

    @Override
    public Field<String> field2() {
        return PdmTableField.PDM_TABLE_FIELD.FIELD_CODE;
    }

    @Override
    public Field<String> field3() {
        return PdmTableField.PDM_TABLE_FIELD.FIELD_TYPE;
    }

    @Override
    public Field<Integer> field4() {
        return PdmTableField.PDM_TABLE_FIELD.FIELD_SIZE;
    }

    @Override
    public Field<String> field5() {
        return PdmTableField.PDM_TABLE_FIELD.FIELD_PRIMARY;
    }

    @Override
    public Field<String> field6() {
        return PdmTableField.PDM_TABLE_FIELD.FIELD_ISNULL;
    }

    @Override
    public Field<String> field7() {
        return PdmTableField.PDM_TABLE_FIELD.FIELD_DESC;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public Field<Object> field8() {
        return PdmTableField.PDM_TABLE_FIELD.TABLE_ID;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public Object component1() {
        return getFieldId();
    }

    @Override
    public String component2() {
        return getFieldCode();
    }

    @Override
    public String component3() {
        return getFieldType();
    }

    @Override
    public Integer component4() {
        return getFieldSize();
    }

    @Override
    public String component5() {
        return getFieldPrimary();
    }

    @Override
    public String component6() {
        return getFieldIsnull();
    }

    @Override
    public String component7() {
        return getFieldDesc();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public Object component8() {
        return getTableId();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public Object value1() {
        return getFieldId();
    }

    @Override
    public String value2() {
        return getFieldCode();
    }

    @Override
    public String value3() {
        return getFieldType();
    }

    @Override
    public Integer value4() {
        return getFieldSize();
    }

    @Override
    public String value5() {
        return getFieldPrimary();
    }

    @Override
    public String value6() {
        return getFieldIsnull();
    }

    @Override
    public String value7() {
        return getFieldDesc();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public Object value8() {
        return getTableId();
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public PdmTableFieldRecord value1(Object value) {
        setFieldId(value);
        return this;
    }

    @Override
    public PdmTableFieldRecord value2(String value) {
        setFieldCode(value);
        return this;
    }

    @Override
    public PdmTableFieldRecord value3(String value) {
        setFieldType(value);
        return this;
    }

    @Override
    public PdmTableFieldRecord value4(Integer value) {
        setFieldSize(value);
        return this;
    }

    @Override
    public PdmTableFieldRecord value5(String value) {
        setFieldPrimary(value);
        return this;
    }

    @Override
    public PdmTableFieldRecord value6(String value) {
        setFieldIsnull(value);
        return this;
    }

    @Override
    public PdmTableFieldRecord value7(String value) {
        setFieldDesc(value);
        return this;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    @Override
    public PdmTableFieldRecord value8(Object value) {
        setTableId(value);
        return this;
    }

    @Override
    public PdmTableFieldRecord values(Object value1, String value2, String value3, Integer value4, String value5, String value6, String value7, Object value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PdmTableFieldRecord
     */
    public PdmTableFieldRecord() {
        super(PdmTableField.PDM_TABLE_FIELD);
    }

    /**
     * Create a detached, initialised PdmTableFieldRecord
     */
    public PdmTableFieldRecord(Object fieldId, String fieldCode, String fieldType, Integer fieldSize, String fieldPrimary, String fieldIsnull, String fieldDesc, Object tableId) {
        super(PdmTableField.PDM_TABLE_FIELD);

        set(0, fieldId);
        set(1, fieldCode);
        set(2, fieldType);
        set(3, fieldSize);
        set(4, fieldPrimary);
        set(5, fieldIsnull);
        set(6, fieldDesc);
        set(7, tableId);
    }
}
