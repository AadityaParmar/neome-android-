// neome.ai API - do not change
//

package com.neome.java.api.app.cli.msg;

import com.neome.java.api.meta.base.Types.ArtifactId;
import com.neome.java.api.meta.base.Types.MetaIdModule;
import com.neome.java.api.meta.base.Types.TimeZoneKey;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgNeoScriptPut extends Msg
{
  public ArtifactId artifactId;

  @Nullable
  public String cliCodeId;

  public String displayDateFormat;

  @Nullable
  public MetaIdModule moduleId;

  public String neoScriptOrUserMessage;

  public TimeZoneKey timeZone;
}
