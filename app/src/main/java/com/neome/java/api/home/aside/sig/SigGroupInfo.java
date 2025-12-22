// neome.ai API - do not change
//

package com.neome.java.api.home.aside.sig;

import com.neome.java.api.home.base.dto.DtoGroupMemberMetaData;
import com.neome.java.api.home.base.dto.DtoGroupSettings;
import com.neome.java.api.home.base.dto.DtoUserGroupConfiguration;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.GroupId;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;
import com.neome.java.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class SigGroupInfo extends SigVersion
{
  public String about;

  public Map<EntUserId, DtoGroupMemberMetaData> adminMap;

  @Nullable
  public Boolean allowPromptAssistant;

  @Nullable
  public MediaIdAvatar avatarId;

  public EntId entId;

  public DtoUserGroupConfiguration groupConfiguration;

  public GroupId groupId;

  @Nullable
  public String label;

  public Map<EntUserId, DtoGroupMemberMetaData> memberMap;

  public String name;

  public DtoGroupSettings settings;
}
