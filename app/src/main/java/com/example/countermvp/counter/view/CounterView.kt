package com.example.countermvp.counter.view

interface CounterView {

    fun showCount(count: Int)
    fun showToast(text: String)
    fun setColor(colorResId: Int, count: Int)

}