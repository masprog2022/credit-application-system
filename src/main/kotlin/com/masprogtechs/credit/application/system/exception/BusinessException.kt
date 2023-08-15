package com.masprogtechs.credit.application.system.exception

import java.lang.RuntimeException

data class BusinessException(
    override val message: String?
): RuntimeException(message) {
}