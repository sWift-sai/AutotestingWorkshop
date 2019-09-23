package sai.swift.autotestingworkshop.camera_grouper.steps

import sai.swift.autotestingworkshop.camera_grouper.Camera
import sai.swift.autotestingworkshop.camera_grouper.CameraGroup
import sai.swift.autotestingworkshop.camera_grouper.CameraGroupType

// Первоначальная реализация SUT после написания тестов
class CameraGrouper_Step4 {

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

        return listOf(
            CameraGroup(
                CameraGroupType.FAVORITE,
                favoriteActiveCameras.toList()
            ),
            CameraGroup(
                CameraGroupType.ALL,
                allActiveCameras.toList()
            )
        )
    }

}
