// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnKindAutomation;
import com.neome.java.api.meta.base.Types.MetaIdAutomation;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomation extends StudioBase
{
  @Nullable
  public Boolean active;

  @Nullable
  public String description;

  public EnumDefnKindAutomation kind;

  public MetaIdAutomation metaId;

  @Nullable
  public StudioModuleSelection modules;

  public Symbol name;

  @Nullable
  public String secondary;
}
