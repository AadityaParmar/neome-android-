// neome.ai API - do not change
//

package com.neome.api.home.main.msg;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgMessageForwardCandidateList extends Msg
{
  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
