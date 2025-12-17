// neome.ai API - do not change
//

package com.neome.api.core.extn.msg;

import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgExtnGstinDetailsGet extends Msg
{
  @Nullable
  public String action;

  public String gstin;
}
