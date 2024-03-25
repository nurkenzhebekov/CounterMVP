package com.example.countermvp.counter

import com.example.countermvp.R
import com.example.countermvp.counter.view.CounterView
import com.example.countermvp.model.Injector

class CounterPresenter(private var counterView: CounterView) {

    private val model = Injector.getModel()

    fun increment() {
        if (model.count == 9) {
            counterView.showToast("Поздравляю")
        }

        if (model.count == 14) {
            counterView.setColor(R.color.green, model.count)
        }

        model.inc()
        counterView.showCount(model.count)
    }

    fun decrement() {
        model.dec()
        counterView.showCount(model.count)

    }
}