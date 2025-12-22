// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.google.gson.JsonElement;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoAgentEntUserImport
{
  public EntUserId entUserId;

  public String handle;

  @Nullable
  public EntUserId managerId;

  public String nickName;

  @Nullable
  public MetaIdRole[] roleIdSet;

  @Nullable
  public Map<MetaIdVar, JsonElement> userVariableValueMap;
}
