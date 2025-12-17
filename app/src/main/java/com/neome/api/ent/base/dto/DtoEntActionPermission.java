// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.EnumDefnDeviceSize;
import com.neome.api.meta.base.Types.MetaIdAction;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntActionPermission
{
  public MetaIdAction actionId;

  @Nullable
  public EnumDefnDeviceSize[] deviceSizeSet;

  @Nullable
  public Boolean hidden;

  @Nullable
  public String menuGroup;
}
