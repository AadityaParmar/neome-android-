// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.ColumnPath;
import com.neome.api.meta.base.Types.EnumSchemaColumnType;
import com.neome.api.meta.base.Types.SymbolColumn;

import java.util.Map;

@SuppressWarnings("unused")
public class SchemaColumn
{
  public ColumnPath columnPath;

  public EnumSchemaColumnType columnType;

  public boolean fieldQueryable;

  public boolean fieldSearchable;

  public boolean loggable;

  public Map<String, String> propertyMap;

  public boolean queryable;

  public boolean searchable;

  public boolean sortable;

  public SymbolColumn symbolColumn;
}
