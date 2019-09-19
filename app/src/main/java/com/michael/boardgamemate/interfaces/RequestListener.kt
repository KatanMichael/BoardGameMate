package com.michael.boardgamemate.interfaces

interface RequestListener<T>
{
    fun onComplete(t: T)
    fun onError(msg: String)
}