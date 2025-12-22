// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnCompType;
import com.neome.java.api.meta.base.Types.MetaIdComp;

import org.jetbrains.annotations.Nullable;

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
