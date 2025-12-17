// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnDeviceSize;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoActionPermission extends StudioBase
{
  @Nullable
  public EnumDefnDeviceSize[] deviceSizeSet;

  @Nullable
  public MetaIdGroup[] groupIdSet;

  @Nullable
  public Boolean hidden;

  @Nullable
  public MetaIdVar inputMappingVarId;

  @Nullable
  public String menuGroup;

  public MetaIdAction metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public MetaIdRole[] notAllowedRoleIdSet;

  @Nullable
  public MetaIdVar outputMappingVarId;

  public MetaIdRole[] roleIdSet;

  @Nullable
  public Boolean showMessageTooltip;
}
