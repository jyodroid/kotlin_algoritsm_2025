fun main() {
    val smartTvDevice = SmartDevice(name = "Android TV")
    smartTvDevice.turnOn()
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
    smartTvDevice.turnOn()
    println(smartTvDevice.category)

    val smartTvDevice2 = SmartDevice(name = "Android TV", category = "Entretainment")
    println(smartTvDevice2.category)

    val smartTv = SmartTvDevice(name = "Android TV", category = "Entretainment")
    smartTv.turnOn()
    smartTv.increaseSpeakerVolume()

    val smartLight = SmartLightDevice("Amazon Bulb", "Home")
    smartLight.turnOn()
    smartLight.increaseBrightness()

    val smartHome = SmartHome()

    smartHome.smartTv.turnOn()
    smartHome.smartLight.turnOn()
}