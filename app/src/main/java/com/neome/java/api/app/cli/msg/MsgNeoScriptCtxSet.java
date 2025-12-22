// neome.ai API - do not change
//

package com.neome.java.api.app.cli.msg;

import com.neome.java.api.app.base.dto.DtoNeoScript;
import com.neome.java.api.meta.base.Types.MetaIdModule;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgNeoScriptCtxSet extends Msg
{
  @Nullable
  public String cliCodeId;

  public DtoNeoScript ctx;

  @Nullable
  public MetaIdModule moduleId;
}
