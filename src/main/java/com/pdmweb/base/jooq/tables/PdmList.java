/*
 * This file is generated by jOOQ.
 */
package com.pdmweb.base.jooq.tables;


import com.pdmweb.base.jooq.DefaultSchema;
import com.pdmweb.base.jooq.Keys;
import com.pdmweb.base.jooq.tables.records.PdmListRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class PdmList extends TableImpl<PdmListRecord> {

    private static final long serialVersionUID = -806855214;

    /**
     * The reference instance of <code>pdm_list</code>
     */
    public static final PdmList PDM_LIST = new PdmList();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PdmListRecord> getRecordType() {
        return PdmListRecord.class;
    }

    /**
     * The column <code>pdm_list.pdm_id</code>.
     */
    public final TableField<PdmListRecord, Integer> PDM_ID = createField(DSL.name("pdm_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>pdm_list.pdm_name</code>.
     */
    public final TableField<PdmListRecord, String> PDM_NAME = createField(DSL.name("pdm_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pdm_list.pdm_version</code>.
     */
    public final TableField<PdmListRecord, String> PDM_VERSION = createField(DSL.name("pdm_version"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pdm_list.update_time</code>.
     */
    public final TableField<PdmListRecord, String> UPDATE_TIME = createField(DSL.name("update_time"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pdm_list.create_time</code>.
     */
    public final TableField<PdmListRecord, String> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pdm_list.pdm_desc</code>.
     */
    public final TableField<PdmListRecord, String> PDM_DESC = createField(DSL.name("pdm_desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pdm_list.pdm_status</code>.
     */
    public final TableField<PdmListRecord, Integer> PDM_STATUS = createField(DSL.name("pdm_status"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>pdm_list</code> table reference
     */
    public PdmList() {
        this(DSL.name("pdm_list"), null);
    }

    /**
     * Create an aliased <code>pdm_list</code> table reference
     */
    public PdmList(String alias) {
        this(DSL.name(alias), PDM_LIST);
    }

    /**
     * Create an aliased <code>pdm_list</code> table reference
     */
    public PdmList(Name alias) {
        this(alias, PDM_LIST);
    }

    private PdmList(Name alias, Table<PdmListRecord> aliased) {
        this(alias, aliased, null);
    }

    private PdmList(Name alias, Table<PdmListRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> PdmList(Table<O> child, ForeignKey<O, PdmListRecord> key) {
        super(child, key, PDM_LIST);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<PdmListRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PDM_LIST;
    }

    @Override
    public UniqueKey<PdmListRecord> getPrimaryKey() {
        return Keys.PK_PDM_LIST;
    }

    @Override
    public List<UniqueKey<PdmListRecord>> getKeys() {
        return Arrays.<UniqueKey<PdmListRecord>>asList(Keys.PK_PDM_LIST);
    }

    @Override
    public PdmList as(String alias) {
        return new PdmList(DSL.name(alias), this);
    }

    @Override
    public PdmList as(Name alias) {
        return new PdmList(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PdmList rename(String name) {
        return new PdmList(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PdmList rename(Name name) {
        return new PdmList(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, String, String, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
