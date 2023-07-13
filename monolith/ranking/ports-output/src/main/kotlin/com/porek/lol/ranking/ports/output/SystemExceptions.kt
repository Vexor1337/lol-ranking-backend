package com.porek.lol.ranking.ports.output

import EitherError

class SystemExceptions {
    sealed interface RiotFeignClientError: EitherError

    class RiotFeignClientGenericError(override val message: String): RiotFeignClientError
}