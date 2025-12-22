// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.ent.base.Types.EnumAutomationStateFilterKind;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class MsgAutomationStateInfoList extends Msg
{
  @Nullable
  public EnumAutomationStateFilterKind[] filterAutomationStateSet;

  @Nullable
  public Date from;

  @Nullable
  public Long limit;
}
