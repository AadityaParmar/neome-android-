// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVar;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetRowSend extends Msg
{
  @Nullable
  public MetaIdAction actionId;

  public FormValueRaw formValueRaw;

  @Nullable
  public MetaIdVar mappingVarId;

  @Nullable
  public MetaIdSpreadsheet targetSpreadsheetId;

  @Nullable
  public String transactionId;
}
