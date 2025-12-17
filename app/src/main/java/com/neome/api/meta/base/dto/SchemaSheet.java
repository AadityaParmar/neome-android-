// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.dto.SchemaFieldMap;
import com.neome.api.meta.base.dto.SchemaGridMap;
import com.neome.api.meta.base.Types.SymbolGrid;

@SuppressWarnings("unused")
public class SchemaSheet
{
  public SchemaFieldMap fieldMap;

  public SymbolGrid formSymbol;

  public SchemaGridMap gridMap;

  public MetaIdForm metaId;
}