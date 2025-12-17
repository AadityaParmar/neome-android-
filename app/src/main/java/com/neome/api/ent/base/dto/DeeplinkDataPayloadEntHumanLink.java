// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.dto.DefnForm;
import com.neome.api.meta.base.dto.FormValueRaw;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DeeplinkDataPayloadEntHumanLink extends DeeplinkDataPayloadEnt
{
  public DefnForm embedFormDefn;

  @Nullable
  public FormValueRaw embedFormValue;

  public EntId entId;

  public String message;

  @Nullable
  public String senderHandle;

  @Nullable
  public String senderName;

  @Nullable
  public String targetHandle;

  @Nullable
  public String targetName;

  public String title;
}
