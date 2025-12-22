// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnLayoutGridKind;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutGrid extends StudioBase
{
  @Nullable
  public MetaIdLayoutGrid[] allowToSwitchLayoutIdSet;

  @Nullable
  public MetaIdField bgColorFieldId;

  @Nullable
  public String description;

  public EnumDefnLayoutGridKind kind;

  @Nullable
  public String label;

  public MetaIdLayoutGrid metaId;

  public Symbol name;

  @Nullable
  public MetaIdField toolTipFieldId;
}
