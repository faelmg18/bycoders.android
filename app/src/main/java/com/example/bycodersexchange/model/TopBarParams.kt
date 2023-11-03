package com.example.bycodersexchange.model

data class TopBarParams(
    var isShowBackButton: Boolean = false,
    var title: String = "",
    var onClick: (() -> Unit)? = null
)