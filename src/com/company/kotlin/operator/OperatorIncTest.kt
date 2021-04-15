package com.company.kotlin.operator

import java.math.BigDecimal

/**
 * 重载自加运算符 ++约定为函数inc
 */
operator fun BigDecimal.inc()=this+ BigDecimal.ONE