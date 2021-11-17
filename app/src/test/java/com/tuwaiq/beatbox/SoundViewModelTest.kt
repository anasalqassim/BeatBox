package com.tuwaiq.beatbox

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.Is
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {

    private lateinit var sound: Sound
    private lateinit var subject:SoundViewModel
    private lateinit var beatBox: BeatBox

    @Before
    fun setUp() {
        sound = Sound("assetsPath",1)
        beatBox = mock(BeatBox::class.java)
        subject = SoundViewModel(beatBox)

        subject.sound = sound

    }

    @Test
    fun titleEqualName(){
        assertEquals( (sound.name),subject.title  )

    }

    @Test
    fun onButtonClicked() {
        subject.onButtonClicked()
        verify(beatBox).play(sound)
    }
}