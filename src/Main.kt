// Subject interface
interface Image {
    fun display()
}

// RealSubject class
class RealImage(private val filename: String) : Image {
    init {
        loadFromDisk()
    }

    private fun loadFromDisk() {
        println("Loading image: $filename")
    }

    override fun display() {
        println("Displaying image: $filename")
    }
}

// Proxy class
class ProxyImage(private val filename: String) : Image {
    private var realImage: RealImage? = null

    override fun display() {
        if (realImage == null) {
            realImage = RealImage(filename)
        }
        realImage?.display()
    }
}

fun main() {
    // Using the Proxy
    val image: Image = ProxyImage("example.jpg")

    // The image is loaded only when display() is called
    image.display()

    // The image is not loaded again, as it's already loaded
    image.display()
}
