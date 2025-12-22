// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAction;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioBuildActionPermission extends DefnField
{
  @Nullable
  public Boolean allowGrouping;

  @Nullable
  public Boolean allowShowMessageTooltip;

  @Nullable
  public Boolean allowSystemRoles;

  @Nullable
  public MetaIdAction[] includeActionIdSet;

  @Nullable
  public DefnStudioMapOfDtoOption includeOptionMap;

  @Nullable
  public Boolean isGroupAction;
}
