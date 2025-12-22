// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumWhatsAppTemplateHeaderType;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class DtoWhatsAppTemplateGroup
{
  @Nullable
  public String carouselCardFormat;

  @Nullable
  public String carouselCardSample;

  @Nullable
  public DtoCarouselTemplateGroup carouselTemplateGroup;

  public String format;

  public String groupId;

  public String groupName;

  public boolean isCarouselTemplate;

  @Nullable
  public Long numberOfButtonParams;

  public long numberOfParams;

  public String sample;

  public Set<EnumWhatsAppTemplateHeaderType> supportedHeaders;
}
