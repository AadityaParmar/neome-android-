// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.msg;

import com.neome.java.api.home.base.dto.DtoGroupSettings;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgGroupCreate extends Msg
{
  @Nullable
  public String about;

  @Nullable
  public MediaIdAvatar mediaIdAvatar;

  public Set<EntUserId> members;

  public String name;

  public DtoGroupSettings settings;
}
