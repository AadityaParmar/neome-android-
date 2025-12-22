// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.home.base.Types.EnumMessageType;
import com.neome.java.api.meta.base.Types.ContactId;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoMessagePayload
{
  @Nullable
  public Boolean isForwarded;

  @Nullable
  public Map<String, ContactId> mentionMap;

  public EnumMessageType messageType;
}
