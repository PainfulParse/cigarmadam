package com.painfulparse.cigarmadam.feature_cigars.domain.usecases

import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.AddCigar
import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.DeleteCigar
import com.painfulparse.cigarmadam.feature_cigars.domain.usecases.GetAllCigars

data class CigarUseCases(
    val getAllCigars: GetAllCigars,
    val addCigar: AddCigar,
    val deleteCigar: DeleteCigar
)
