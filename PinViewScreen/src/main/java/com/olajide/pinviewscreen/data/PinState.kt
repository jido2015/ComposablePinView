package com.olajide.pinviewscreen.data

import androidx.compose.runtime.snapshots.SnapshotStateList

data class PinState(
    val pin: String = "",
    var pinLimit: Int =0,
    val pinListState: SnapshotStateList<Boolean> = SnapshotStateList()

)
