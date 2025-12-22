// neome.ai API - do not change
//

package com.neome.java.api.core.deeplink.sig;

import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class SigDeeplinkHtml extends Sig
{
  @Nullable
  public String content;

  @Nullable
  public Map<String, String> contentHeaders;

  @Nullable
  public String contentType;

  @Nullable
  public Boolean isBase64Content;
}
