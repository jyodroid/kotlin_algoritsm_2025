import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(private val name: String) {
    var category: String? = null
    constructor(name: String, category: String): this(name){
        this.category = category
    }

    private var isOn = false

    fun turnOn(){
        if(isOn){
            turnOff()
        } else {
            isOn = true
            println("Smart Device $name turned on")
        }
    }

    fun turnOff(){
        println("Smart Device $name turned off")
        isOn = false
    }
}

class SmartTvDevice(name: String, category: String) :
    SmartDevice(name = name, category = category) {

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)


    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
}

class SmartHome(){
    val smartTv = SmartTvDevice(name = "Android TV", category = "Entretainment")
    val smartLight = SmartLightDevice("Amazon Bulb", "Home")
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue

//    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100) //this will generate a stack overflow

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}