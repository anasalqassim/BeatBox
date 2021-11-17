package com.tuwaiq.beatbox

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel(val beatBox: BeatBox): BaseObservable() {


    fun onButtonClicked(){
        sound?.let {
            beatBox.play(it)
        }


    }





    var sound:Sound? = null
        set(sound){
            field = sound
            notifyChange()
            //notifyPropertyChanged()
        }


    @get:Bindable
    val title:String?
        get() = sound?.name





}