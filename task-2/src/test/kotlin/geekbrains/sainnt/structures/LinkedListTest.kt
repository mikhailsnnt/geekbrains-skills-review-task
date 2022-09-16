package geekbrains.sainnt.structures

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals


class LinkedListTest{
    @Test
    fun shouldAddAndGet(){
        val list = LinkedList<Int>()
        list += 1
        list += 2
        list += 3
        assertEquals(1,list[0])
        assertEquals(2,list[1])
        assertEquals(3,list[2])
    }

    @Test
    fun shouldIterate(){
        val list = LinkedList<Int>()
        list += listOf(1,2,3,4,5)
        val elements = mutableSetOf<Int>()
        list.forEach(elements::add)
        assertContentEquals(listOf(1,2,3,4,5),elements)
    }
}
