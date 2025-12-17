// neome.ai API - do not change
//

package com.neome.api.home.drawer.sig;

import com.neome.api.home.base.dto.DtoChatBadgeMap;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.nucleus.base.sig.SigVersion;

import java.util.Map;

@SuppressWarnings("unused")
public class SigBadgeMap extends SigVersion
{
  public Map<EntId, DtoChatBadgeMap> entChatBadgeMap;
}
