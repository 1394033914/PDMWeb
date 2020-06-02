package com.pdmweb.base.data;


import com.pdmweb.base.jooq.tables.PdmList;
import com.pdmweb.base.jooq.tables.PdmTable;
import com.pdmweb.base.jooq.tables.PdmTableField;
import com.pdmweb.base.jooq.tables.PdmUser;


/**
 * Convenience access to all tables in 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BaseTables {

    /**
     * The table <code>pdm_list</code>.
     */
    public static final PdmList listTable = PdmList.PDM_LIST;

    /**
     * The table <code>pdm_table</code>.
     */
    public static final PdmTable pdmTable = PdmTable.PDM_TABLE;

    /**
     * The table <code>pdm_table_field</code>.
     */
    public static final PdmTableField fieldTable = PdmTableField.PDM_TABLE_FIELD;

    /**
     * The table <code>pdm_user</code>.
     */
    public static final PdmUser userTable = PdmUser.PDM_USER;
}
