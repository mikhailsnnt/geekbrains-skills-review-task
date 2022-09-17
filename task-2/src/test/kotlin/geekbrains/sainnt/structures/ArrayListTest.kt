package geekbrains.sainnt.structures

import org.junit.Test
import kotlin.collections.ArrayList
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals


class ArrayListTest{
    @Test
    fun shouldAddAndGet(){
        val list = ArrayList<Int>()
        list += 1
        list += 2
        list += 3
        assertEquals(1,list[0])
        assertEquals(2,list[1])
        assertEquals(3,list[2])
    }

    @Test
    fun shouldSetAndGet(){
        val list = ArrayList<Int>()
        list += 1
        list += 2
        list += 3
        list[1] = 5
        assertEquals(1,list[0])
        assertEquals(5,list[1])
        assertEquals(3,list[2])
    }

    @Test
    fun shouldIterate(){
        val list = ArrayList<Int>()
        list += listOf(1,2,3,4,5)
        val elements = mutableSetOf<Int>()
        list.forEach(elements::add)
        assertContentEquals(listOf(1,2,3,4,5),elements)
    }
}