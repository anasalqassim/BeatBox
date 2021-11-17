package com.tuwaiq.beatbox

import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log
import java.io.IOException
import java.lang.Exception

private const val TAG = "BeatBox"
private const val SOUNDS_FOLDER = "sample_sounds"
private const val MAX_SOUNDS = 5

class BeatBox(private val assets:AssetManager) {

    private val soundPool = SoundPool.Builder()
        .setMaxStreams(MAX_SOUNDS)
        .build()

    fun play(sound: Sound){
        sound.soundId?.let {
            soundPool.play(it,1.0f,1.0f,1,0,1.0f)
        }


    }

    fun release(){
        soundPool.release()
    }

    private fun load(sound:Sound){

        val assetFileDescriptor = assets.openFd(sound.assetsPath)

        val soundId = soundPool.load(assetFileDescriptor,1)

        sound.soundId = soundId

    }





    fun loadSounds():List<Sound>{

        val soundsName : Array<String>

        try {
             soundsName = assets.list(SOUNDS_FOLDER)!!
        }catch (e:Exception){
            Log.e(TAG,"there is a problem",e)
            return emptyList()
        }

        val sounds = mutableListOf<Sound>()

        soundsName.forEach { fileName->
            val assetsPath = "$SOUNDS_FOLDER/$fileName"
           val sound = Sound(assetsPath)

            try {
                load(sound)
                sounds.add(sound)
            }catch (ioe:IOException){

            }



        }


        return sounds
    }



}