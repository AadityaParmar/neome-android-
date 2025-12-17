// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.ChatId;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetInsertShare extends Msg
{
  public MetaIdAction actionId;

  public ChatId chatId;

  @Nullable
  public FormValueRaw formValueRaw;

  @Nullable
  public Boolean reset;
}
