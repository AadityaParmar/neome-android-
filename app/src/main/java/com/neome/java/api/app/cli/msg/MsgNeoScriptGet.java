// neome.ai API - do not change
//

package com.neome.java.api.app.cli.msg;

import com.neome.java.api.meta.base.SysId;
import com.neome.java.api.meta.base.Types.ArtifactId;
import com.neome.java.api.meta.base.Types.TimeZoneKey;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgNeoScriptGet extends Msg
{
  public ArtifactId artifactId;

  public String displayDateFormat;

  @Nullable
  public SysId metaId;

  public TimeZoneKey timeZone;
}
