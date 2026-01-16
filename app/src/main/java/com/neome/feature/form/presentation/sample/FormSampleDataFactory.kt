package com.neome.feature.form.presentation.sample

import com.neome.api.meta.base.AnyValue
import com.neome.api.meta.base.Symbol
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.utils.JsonParser

/**
 * Provides lightweight sample DefnForm data for demos/tests.
 */
object FormSampleDataFactory {

    fun createTextForm(): DefnFormData {
        val jsonString = this.createSampleDefnForm()
        return JsonParser.json.decodeFromString<DefnFormData>(jsonString)
    }

    private fun symbol(value: String): Symbol {
        return AnyValue.create(value, Symbol::class.java)!!
    }

    fun createSampleDefnForm(): String {
        return """
{
    "metaId": "mf-pdPRpwtlFt",
    "name": "DefnForm",
    "compMap": {
        "mtb-pdPRpwtlFt": {
            "metaId": "mtb-pdPRpwtlFt",
            "tabIdSet": [
                "msc-MgknD5pYZT",
                "msc-iq4fe3O1IV",
                "mgr-QtTkTuXYKw"
            ],
            "name": "DefnForm",
            "type": "tab",
            "disabled": false
        },
        "mfd-HxbXkSxSQY": {
            "requiredFieldId": "mfd-qDpfN1vSGT",
            "placeHolderFieldId": "mfd-63HKAMm6LQ",
            "helperTextFieldId": "mfd-q96ZG1wLEp",
            "metaId": "mfd-HxbXkSxSQY",
            "name": "FieldText",
            "type": "text",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-qDpfN1vSGT": {
            "helperTextFieldId": "mfd-HxbXkSxSQY",
            "metaId": "mfd-qDpfN1vSGT",
            "name": "FieldBool",
            "type": "bool",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-1R1vfYHuYg": {
            "defaultValue": 10,
            "metaId": "mfd-1R1vfYHuYg",
            "name": "FieldNumber",
            "type": "number",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-pAGBF98cPc": {
            "optionMap": {
                "keys": [
                    "keyRed",
                    "keyGreen",
                    "keyBlue"
                ],
                "map": {
                    "keyRed": {
                        "metaId": "keyRed",
                        "value": "Red",
                        "color": {
                            "value": "red",
                            "shade": "s500"
                        },
                        "isRemoved": false,
                        "disabled": false
                    },
                    "keyGreen": {
                        "metaId": "keyGreen",
                        "value": "Green",
                        "color": {
                            "value": "green",
                            "shade": "s500"
                        },
                        "isRemoved": false,
                        "disabled": false
                    },
                    "keyBlue": {
                        "metaId": "keyBlue",
                        "value": "Blue",
                        "color": {
                            "value": "blue",
                            "shade": "s500"
                        },
                        "isRemoved": false,
                        "disabled": false
                    }
                }
            },
            "metaId": "mfd-pAGBF98cPc",
            "name": "FieldPickText",
            "type": "pickText",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-JiBn57WwT1": {
            "metaId": "mfd-JiBn57WwT1",
            "name": "FieldDecimal",
            "type": "decimal",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "msc-MgknD5pYZT": {
            "metaId": "msc-MgknD5pYZT",
            "fieldIdSet": [
                "mfd-HxbXkSxSQY",
                "mfd-qDpfN1vSGT",
                "mfd-1R1vfYHuYg",
                "mfd-pAGBF98cPc",
                "mfd-JiBn57WwT1"
            ],
            "flexGrow": false,
            "name": "Section1",
            "type": "section",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-k9fXu7XtBX": {
            "metaId": "mfd-k9fXu7XtBX",
            "name": "FieldDate",
            "type": "date",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-gdb26wJtRW": {
            "metaId": "mfd-gdb26wJtRW",
            "name": "FieldEmail",
            "type": "email",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-63HKAMm6LQ": {
            "metaId": "mfd-63HKAMm6LQ",
            "name": "Placeholder",
            "type": "text",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-q96ZG1wLEp": {
            "metaId": "mfd-q96ZG1wLEp",
            "name": "Helpertext",
            "type": "text",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "msc-iq4fe3O1IV": {
            "metaId": "msc-iq4fe3O1IV",
            "fieldIdSet": [
                "mfd-k9fXu7XtBX",
                "mfd-gdb26wJtRW",
                "mfd-63HKAMm6LQ",
                "mfd-q96ZG1wLEp"
            ],
            "flexGrow": false,
            "name": "Section2",
            "type": "section",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-wIACoHHagW": {
            "metaId": "mfd-wIACoHHagW",
            "name": "GridFieldText",
            "type": "text",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mfd-QtN0Joxw3j": {
            "metaId": "mfd-QtN0Joxw3j",
            "name": "GridFieldBool",
            "type": "bool",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        },
        "mgr-QtTkTuXYKw": {
            "metaId": "mgr-QtTkTuXYKw",
            "fieldIdSet": [
                "mfd-wIACoHHagW",
                "mfd-QtN0Joxw3j"
            ],
            "name": "Grid",
            "type": "grid",
            "permissionMatrix": {
                "keys": [],
                "map": {}
            }
        }
    },
    "displayCompositeId": "mtb-pdPRpwtlFt",
    "gridLookupMap": {}
}
        """.trimIndent()
    }
}
