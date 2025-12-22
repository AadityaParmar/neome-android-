// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnDeviceSize;
import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdGroup;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioDtoActionPermission
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
  public MetaIdRole[] notAllowedRoleIdSet;

  @Nullable
  public MetaIdVar outputMappingVarId;

  public MetaIdRole[] roleIdSet;

  @Nullable
  public Boolean showMessageTooltip;
}
