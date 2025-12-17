// neome.ai API - do not change
//

package com.neome.api.ent.entDrawer.msg;

import com.google.gson.JsonElement;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class MsgEntVariableUpdate extends Msg
{
  @Nullable
  public Map<MetaIdVar, JsonElement> variableObjectMap;
}
