package com.clip.interview.route

object Route {
    const val V1 = "/v1"

    object Transaction {
        const val TRANSACTIONS = "/transactions"
        const val GET_TRANSACTIONS = "$TRANSACTIONS/{id}"
        const val SUM_TRANSACTIONS = "$TRANSACTIONS/sum"
        const val REPORT = "$TRANSACTIONS/report/{type}"
        const val RANDOM_TRANSACTION = "$TRANSACTIONS/feeling-lucky"
    }
}
