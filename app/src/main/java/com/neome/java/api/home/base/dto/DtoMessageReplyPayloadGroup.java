// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.GroupId;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoMessageReplyPayloadGroup extends DtoMessageReplyPayload
{
  @Nullable
  public String about;

  @Nullable
  public EntId entId;

  @Nullable
  public GroupId groupId;

  @Nullable
  public MediaIdAvatar mediaIdAvatar;

  @Nullable
  public String name;
}
