package eu.stefanwimmer128.easystorage

import java.io.Serializable
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.io.IOException
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.File

/**
 * @author Stefan Wimmer <info@stefanwimmer128.eu>
 */
object EasyStorage
{
    @Throws(IOException::class)
    private fun file(filename: String): Boolean
    {
        val file = File(filename)
        
        if (file.isDirectory)
            throw IllegalArgumentException()
        
        return file.createNewFile()
    }
    
    @JvmStatic
    @Throws(ClassNotFoundException::class, IOException::class)
    fun <T : Serializable> load(filename: String): T?
    {
        if (file(filename))
            throw IllegalArgumentException()
        
        val ois = ObjectInputStream(FileInputStream(filename))
        val t = ois.readObject() as T
        ois.close()
        
        return t
    }
    
    @JvmStatic
    @Throws(IOException::class)
    fun <T : Serializable> store(t: T, filename: String)
    {
        file(filename)
        
        val oos = ObjectOutputStream(FileOutputStream(filename))
        oos.writeObject(t)
        oos.flush()
        oos.close()
    }
}
