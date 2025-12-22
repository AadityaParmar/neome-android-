// neome.ai API - do not change
//

package com.neome.java.api.app.ai.msg;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.dto.FormRefKey;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class MsgAiNeoQLGet extends Msg
{
  @Nullable
  public FormRefKey inputFormRefKey;

  @Nullable
  public String neoQL;

  @Nullable
  public FormRefKey outputFormRefKey;

  @Nullable
  public Map<String, FormRefKey> paramMap;

  public Set<MetaIdSpreadsheet> spreadsheetIdSet;

  public String userMessage;
}
