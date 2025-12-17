// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.ent.base.dto.DtoFieldFilterOption;
import com.neome.api.meta.base.Types.EnumDefnCompType;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Symbol;

@SuppressWarnings("unused")
public class DtoFieldFilter
{
  public EnumDefnCompType defnFieldType;

  @Nullable
  public String label;

  public MetaIdComp metaIdField;

  public Symbol name;

  @Nullable
  public DtoFieldFilterOption[] valueList;
}
