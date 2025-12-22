// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVdErdDia;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdErdDia extends EntVdDia
{
  @Nullable
  public Map<MetaIdSpreadsheet, EntVdErdEntity> entityMap;

  @Nullable
  public String label;

  public MetaIdVdErdDia metaId;

  public Symbol name;

  @Nullable
  public Map<MetaIdField, EntVdErdRef> refMap;
}
