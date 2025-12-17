// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetRowUpdate extends Msg
{
  public FormValueRaw formValueRaw;

  public MetaIdSpreadsheet spreadsheetId;

  @Nullable
  public String transactionId;
}
