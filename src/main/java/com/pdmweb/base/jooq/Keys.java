/*
 * This file is generated by jOOQ.
 */
package com.pdmweb.base.jooq;


import com.pdmweb.base.jooq.tables.PdmList;
import com.pdmweb.base.jooq.tables.PdmTable;
import com.pdmweb.base.jooq.tables.PdmTableField;
import com.pdmweb.base.jooq.tables.PdmUser;
import com.pdmweb.base.jooq.tables.records.PdmListRecord;
import com.pdmweb.base.jooq.tables.records.PdmTableFieldRecord;
import com.pdmweb.base.jooq.tables.records.PdmTableRecord;
import com.pdmweb.base.jooq.tables.records.PdmUserRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code></code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<PdmListRecord, Integer> IDENTITY_PDM_LIST = Identities0.IDENTITY_PDM_LIST;
    public static final Identity<PdmUserRecord, Integer> IDENTITY_PDM_USER = Identities0.IDENTITY_PDM_USER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<PdmListRecord> PK_PDM_LIST = UniqueKeys0.PK_PDM_LIST;
    public static final UniqueKey<PdmTableRecord> PK_PDM_TABLE = UniqueKeys0.PK_PDM_TABLE;
    public static final UniqueKey<PdmTableFieldRecord> PK_PDM_TABLE_FIELD = UniqueKeys0.PK_PDM_TABLE_FIELD;
    public static final UniqueKey<PdmUserRecord> PK_PDM_USER = UniqueKeys0.PK_PDM_USER;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<PdmListRecord, Integer> IDENTITY_PDM_LIST = Internal.createIdentity(PdmList.PDM_LIST, PdmList.PDM_LIST.PDM_ID);
        public static Identity<PdmUserRecord, Integer> IDENTITY_PDM_USER = Internal.createIdentity(PdmUser.PDM_USER, PdmUser.PDM_USER.USER_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<PdmListRecord> PK_PDM_LIST = Internal.createUniqueKey(PdmList.PDM_LIST, "pk_pdm_list", PdmList.PDM_LIST.PDM_ID);
        public static final UniqueKey<PdmTableRecord> PK_PDM_TABLE = Internal.createUniqueKey(PdmTable.PDM_TABLE, "pk_pdm_table", PdmTable.PDM_TABLE.TABLE_ID);
        public static final UniqueKey<PdmTableFieldRecord> PK_PDM_TABLE_FIELD = Internal.createUniqueKey(PdmTableField.PDM_TABLE_FIELD, "pk_pdm_table_field", PdmTableField.PDM_TABLE_FIELD.FIELD_ID);
        public static final UniqueKey<PdmUserRecord> PK_PDM_USER = Internal.createUniqueKey(PdmUser.PDM_USER, "pk_pdm_user", PdmUser.PDM_USER.USER_ID);
    }
}
