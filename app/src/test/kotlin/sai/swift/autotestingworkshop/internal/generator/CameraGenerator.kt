package sai.swift.autotestingworkshop.internal.generator

import sai.swift.autotestingworkshop.camera_grouper.Camera

object CameraGenerator {

    fun createCamera(
        id: String = "0",
        name: String = "camera",
        description: String? = null,
        image: String? = null,
        isActive: Boolean = true,
        isFavorite: Boolean = false,
        model: String? = null,
        vendor: String? = null,
        serialNumber: String = "",
        streamToken: String = "defaultFakeToken42"
    ): Camera {
        return Camera(
            id = id,
            name = name,
            description = description,
            image = image,
            isActive = isActive,
            isFavorite = isFavorite,
            model = model,
            vendor = vendor,
            serialNumber = serialNumber,
            streamToken = streamToken
        )
    }

}