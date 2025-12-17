// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind;
import com.neome.api.meta.base.Types.MediaIdAvatar;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntGroup extends StudioBase
{
  @Nullable
  public StudioMapOfActionPermission actionPermissionMap;

  @Nullable
  public Boolean allowPromptAssistant;

  @Nullable
  public MediaIdAvatar avatarId;

  @Nullable
  public MetaIdRole[] chatPermissionSet;

  @Nullable
  public MetaIdAction defaultActionId;

  public StudioDetails details;

  @Nullable
  public Boolean freeze;

  @Nullable
  public EnumDefnFreezeAvatarKind freezeAvatarKind;

  @Nullable
  public String freezeSortName;

  @Nullable
  public MetaIdRole[] groupPermissionSet;

  @Nullable
  public Boolean hideActionMenu;

  @Nullable
  public Boolean hideMembers;

  public MetaIdGroup metaId;

  @Nullable
  public MetaIdAction[] pinnedActionIdSet;

  @Nullable
  public MetaIdAction[] pinnedActionIdSetMobile;

  @Nullable
  public MetaIdRole[] removeMessagePermissionSet;
}
