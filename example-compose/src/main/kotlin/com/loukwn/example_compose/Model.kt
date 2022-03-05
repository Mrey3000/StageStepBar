package com.loukwn.example_compose

import androidx.compose.ui.graphics.Color
import com.loukwn.stagestepbar_compose.data.StageStepBarConfig
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

data class UiModel(
    val stageStepBarConfig: StageStepBarConfig,
    val currentStage: Int,
    val currentStep: Int,
) {
    companion object {
        fun default() = UiModel(
            stageStepBarConfig = StageStepBarConfig.default()
                .copy(stageStepConfig = listOf(5, 5, 5)),
            currentStage = 2,
            currentStep = 3,
        )
    }
}

sealed class Event {
    object Close: Event()
}

enum class ComponentType(val title: String) {
    FilledTrack("Filled Track"),
    UnfilledTrack("Unfilled Track"),
    FilledThumb("Filled Thumb"),
    UnfilledThumb("Unfilled Thumb"),
}

interface Interactions {
    fun onClosePressed()
    fun onStepsInStagesConfigChanged(value: List<Int>)
    fun onCurrentStateMadeNull(isNull: Boolean)
    fun onCurrentStateStageChanged(value: Int)
    fun onCurrentStateStepsChanged(value: Int)
    fun onAnimationStateChanged(value: Boolean)
    fun onAnimationDurationChanged(value: Int)
    fun onOrientationSelected(position: Int)
    fun onHorizontalDirectionSelected(position: Int)
    fun onVerticalDirectionSelected(position: Int)
    fun onComponentDropdownSelectionChanged(component: ComponentType, position: Int, color: Color)
    fun onThumbSizeChanged(value: Float)
    fun onFilledTrackCrossAxisSizeChanged(value: Float)
    fun onUnfilledTrackCrossAxisSizeChanged(value: Float)
    fun onShowThumbsChanged(enabled: Boolean)
    fun onDrawBehindThumbsChanged(value: Boolean)
}

interface ViewModelContract : Interactions {
    val uiModels: StateFlow<UiModel>
    val events: StateFlow<Event?>
}