package geekbrains.sainnt.structures

class ArrayList<T>: Iterable<T>{
    private var content: Array<Any?> = Array(5) { null }
    private var lastIndex = 0

    fun size() = lastIndex

    fun add(element: T){
        if(lastIndex >= content.size){
            content = Array((content.size * 1.5).toInt())
            {if (it < content.size) content[it] else null }
        }
        content[lastIndex++] = element
    }

    operator fun get(i: Int): T{
        if(i >= lastIndex || i < 0)
            throw IndexOutOfBoundsException()
        return content[i] as T
    }

    operator fun set(i: Int, element: T){
        if(i >= lastIndex || i < 0)
            throw IndexOutOfBoundsException()
        content[i] = element
    }

    operator fun plusAssign(element: T) = add(element)
    override fun iterator(): Iterator<T> {
        return object : Iterator<T>{
            var currentIndex = 0

            override fun hasNext(): Boolean {
                return currentIndex < lastIndex
            }

            override fun next(): T {
                return if(currentIndex < lastIndex)
                    content[currentIndex] as T
                else
                    throw IllegalStateException()
            }
        }
    }
}