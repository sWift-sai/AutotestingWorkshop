package sai.swift.autotestingworkshop.camera_grouper

data class Camera(
    val id: String,
    val name: String,
    val description: String?,
    val image: String?,
    val isActive: Boolean,
    val isFavorite: Boolean,
    val model: String?,
    val vendor: String?,
    val serialNumber: String,
    val streamToken: String
)
