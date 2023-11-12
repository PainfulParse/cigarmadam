package com.painfulparse.cigarmadam.domain.usecases.base

import com.painfulparse.cigarmadam.domain.usecases.AddCigar
import com.painfulparse.cigarmadam.domain.usecases.DeleteCigar
import com.painfulparse.cigarmadam.domain.usecases.GetAllCigars

class UseCaseProvider(
    val getAllCigars: GetAllCigars,
    val addCigar: AddCigar,
    val deleteCigar: DeleteCigar
)