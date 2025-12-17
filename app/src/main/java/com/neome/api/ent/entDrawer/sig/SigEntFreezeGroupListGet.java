// neome.ai API - do not change
//

package com.neome.api.ent.entDrawer.sig;

import com.neome.api.ent.base.dto.DtoEntGroupFreezeSettingMap;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigEntFreezeGroupListGet extends Sig
{
  public Map<EntId, DtoEntGroupFreezeSettingMap> entMap;
}
