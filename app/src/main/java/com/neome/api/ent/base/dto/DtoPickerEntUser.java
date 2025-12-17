// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.google.gson.JsonElement;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MediaId;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoPickerEntUser
{
  @Nullable
  public MediaId avatarId;

  public EntUserId entUserId;

  public String nickName;

  @Nullable
  public Map<MetaIdVar, JsonElement> userSettingValueMap;
}
