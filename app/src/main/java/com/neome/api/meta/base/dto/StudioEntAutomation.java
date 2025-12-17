// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.EnumDefnKindAutomation;
import com.neome.api.meta.base.Types.MetaIdAutomation;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioModuleSelection;
import com.neome.api.meta.base.Symbol;

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
