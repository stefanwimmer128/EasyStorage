package eu.stefanwimmer128.easystorage

import java.io.Serializable

/**
 * @author Stefan Wimmer <info@stefanwimmer128.eu>
 */
open class StorageMap<K : Serializable, V : Serializable>(map: Map<K, V>) : Map<K, V> by map, Serializable
{
    companion object
    {
        @JvmStatic
        fun <K : Serializable, V : Serializable> load(filename: String): StorageMap<K, V> =
            EasyStorage.load<StorageMap<K, V>>(filename) ?: StorageMap<K, V>()
    }
    
    constructor(initialCapacity: Int, loadFactor: Float) : this(HashMap<K, V>(initialCapacity, loadFactor))
    
    constructor(initialCapacity: Int) : this(HashMap<K, V>(initialCapacity))
    
    constructor() : this(HashMap<K, V>())
}
