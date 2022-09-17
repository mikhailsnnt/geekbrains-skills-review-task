package geekbrains.sainnt.structures

class LinkedList<T> : Iterable<T> {
    private var firstNode: Node<T>? = null
    private var lastNode: Node<T>? = null

    fun add(element: T){
        val newNode = Node(null, element)
        lastNode?.apply {
            next = newNode
        }
        lastNode = newNode
        if(firstNode == null)
            firstNode = newNode
    }

    fun add(elements: Collection<T>) = elements.forEach(this::add)

    operator fun plusAssign(element: T) = add(element)

    operator fun plusAssign(elements: Collection<T>) = add(elements)

    operator fun get(i: Int):T{
        if(i < 0)
            throw IllegalArgumentException()
        else if(firstNode == null)
            throw IndexOutOfBoundsException() //quick
        var offset = 0
        var current = firstNode!!
        while (offset++ < i)
            current = current.next ?: throw IndexOutOfBoundsException()
        return current.value
    }

    override fun iterator(): Iterator<T> {
        return object: Iterator<T>{
            private var current: Node<T>? = firstNode
            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): T {
                val value = current!!.value
                current = current?.next
                return value
            }

        }
    }

    private data class Node<T>(
        var next: Node<T>?,
        val value: T
    )
}