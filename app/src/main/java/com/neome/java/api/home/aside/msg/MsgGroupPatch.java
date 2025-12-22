// neome.ai API - do not change
//

package com.neome.java.api.home.aside.msg;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.home.base.Types.EnumGroupPatchPropName;
import com.neome.java.api.home.base.dto.DtoGroupSettings;
import com.neome.java.api.meta.base.Types.GroupId;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgGroupPatch extends MsgVersion
{
  @Nullable
  public String about;

  public GroupId groupId;

  @Nullable
  public MediaIdAvatar mediaIdAvatar;

  @Nullable
  public String name;

  public Set<EnumGroupPatchPropName> patchPropNameSet;

  @Nullable
  public DtoGroupSettings settings;
}
