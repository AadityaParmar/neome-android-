// neome.ai API - do not change
//

package com.neome.api.app.cli.msg;

import com.neome.api.app.base.dto.DtoNeoScript;
import com.neome.api.meta.base.Types.MetaIdModule;
import com.neome.api.nucleus.base.msg.Msg;

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
