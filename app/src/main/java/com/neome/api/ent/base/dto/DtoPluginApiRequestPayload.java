// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.MetaIdPlugin;
import com.neome.api.meta.base.Types.PluginApiId;
import com.neome.api.meta.base.Types.RequestId;
import com.neome.api.meta.base.dto.EntUserIdTriple;
import com.neome.api.meta.base.dto.FormValueRaw;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoPluginApiRequestPayload
{
  @Nullable
  public EntUserIdTriple callerTriplet;

  public PluginApiId pluginApiId;

  public MetaIdPlugin pluginId;

  @Nullable
  public FormValueRaw pluginInputFormValue;

  public RequestId requestId;

  public String responseActorPath;
}
