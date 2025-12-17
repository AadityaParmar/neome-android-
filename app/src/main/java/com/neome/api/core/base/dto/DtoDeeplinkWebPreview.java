// neome.ai API - do not change
//

package com.neome.api.core.base.dto;

import com.neome.api.core.base.Types.EnumDeeplinkActionType;
import com.neome.api.meta.base.Types.MediaIdAvatar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoDeeplinkWebPreview
{
  @Nullable
  public MediaIdAvatar avatarId;

  @Nullable
  public EnumDeeplinkActionType deeplinkActionType;

  @Nullable
  public String desc;

  @Nullable
  public String info;

  @Nullable
  public String senderName;

  @Nullable
  public String targetName;

  @Nullable
  public String title;
}
