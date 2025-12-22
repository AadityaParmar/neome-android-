// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class EntVdAiAgent : EntVdAiWithOutput() {
    var agentControlMap: EntVdAiAgentControlMap? = null
    var outputForm: FormRefKey? = null
    var systemMessage: StudioValueParagraph? = null
    var userMessage: StudioValueParagraph? = null
}
