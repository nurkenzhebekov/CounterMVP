package com.example.countermvp.model

import com.example.countermvp.counter.CounterPresenter
import com.example.countermvp.counter.view.CounterView

class Injector {

    companion object {
        fun getModel() = CounterModel()
        fun getPresenter(view: CounterView) = CounterPresenter(view)
    }
}