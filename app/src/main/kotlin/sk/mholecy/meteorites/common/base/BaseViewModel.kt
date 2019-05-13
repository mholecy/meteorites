package sk.mholecy.meteorites.common.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), LifecycleObserver {

    private var hasStartedAlready = false

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    internal fun onStartViewModel() {
        if (!hasStartedAlready) {
            onStart()
            hasStartedAlready = true
        }
    }

    open fun onStart() {}
}