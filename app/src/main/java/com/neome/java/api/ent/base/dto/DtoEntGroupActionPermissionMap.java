// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAction;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoEntGroupActionPermissionMap
{
  @Nullable
  public MetaIdAction defaultActionId;

  @Nullable
  public MetaIdAction[] defaultPinnedActionIdSet;

  @Nullable
  public Boolean hideActionMenu;

  public MetaIdAction[] keys;

  public Map<MetaIdAction, DtoEntActionPermission> map;

  @Nullable
  public MetaIdAction[] mobilePinnedActionIdSet;
}
