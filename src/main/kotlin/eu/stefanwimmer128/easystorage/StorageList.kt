package eu.stefanwimmer128.easystorage

import java.io.Serializable

/**
 * @author Stefan Wimmer <info@stefanwimmer128.eu>
 */
open class StorageList<E : Serializable>(list: List<E>) : List<E> by list, Serializable
{
    companion object
    {
        @JvmStatic
        fun <E : Serializable> load(filename: String): StorageList<E> =
            EasyStorage.load<StorageList<E>>(filename) ?: StorageList<E>()
    }
    
    constructor(initialCapacity: Int) : this(ArrayList<E>(initialCapacity))
    
    constructor() : this(ArrayList<E>())
    
    constructor(collection: Collection<E>) : this(ArrayList<E>(collection))
    
    fun store(filename: String) =
        EasyStorage.store(this, filename)
}
