package sai.swift.autotestingworkshop.camera_grouper.steps

import sai.swift.autotestingworkshop.camera_grouper.Camera
import sai.swift.autotestingworkshop.camera_grouper.CameraGroup
import sai.swift.autotestingworkshop.camera_grouper.CameraGroupType.ALL
import sai.swift.autotestingworkshop.camera_grouper.CameraGroupType.FAVORITE

// Исправленная реализация
class CameraGrouper_Step5 {

    /**
     * Функция принимает список камер [cameras] и преобразует их в список групп.
     *
     * Группировка происходит по признаку [Camera.isFavorite].
     * Неактивные камеры отбрасываются [Camera.isActive].
     *
     * При наличии активных избранных камер, группа типа [CameraGroupType.FAVORITE] идет первой,
     * затем идет группа типа [CameraGroupType.ALL], содержащая все активные камеры,
     * в том числе избранные.
     */
    fun transformCamerasToGroups(cameras: List<Camera>): List<CameraGroup> {

        if (cameras.isEmpty()) return emptyList()

        val favoriteActiveCameras = mutableSetOf<Camera>()
        val allActiveCameras = mutableSetOf<Camera>()

        cameras.forEach {
            when {
                it.isActive && it.isFavorite -> {
                    favoriteActiveCameras.add(it)
                    allActiveCameras.add(it)
                }

                it.isActive && !it.isFavorite -> { allActiveCameras.add(it) }
            }
        }

        val cameraGroups = mutableSetOf<CameraGroup>()
        if (favoriteActiveCameras.isNotEmpty()) {
            cameraGroups.add(
                CameraGroup(
                    FAVORITE,
                    favoriteActiveCameras.toList()
                )
            )
        }
        if (allActiveCameras.isNotEmpty()) {
            cameraGroups.add(
                CameraGroup(
                    ALL,
                    allActiveCameras.toList()
                )
            )
        }

        return cameraGroups.toList()
    }

}
