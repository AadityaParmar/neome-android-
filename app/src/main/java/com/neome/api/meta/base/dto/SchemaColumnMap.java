// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnCompType;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.SymbolColumn;

import java.util.Map;

@SuppressWarnings("unused")
public class SchemaColumnMap
{
  public Map<SymbolColumn, SchemaColumn> columnMap;

  public MetaIdField fieldId;

  public EnumDefnCompType fieldType;
}
