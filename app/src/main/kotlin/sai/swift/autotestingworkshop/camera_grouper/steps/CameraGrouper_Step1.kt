package sai.swift.autotestingworkshop.camera_grouper.steps

import sai.swift.autotestingworkshop.camera_grouper.Camera
import sai.swift.autotestingworkshop.camera_grouper.CameraGroup

// Создаем класс и объявляем функцию
class CameraGrouper_Step1 {

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
        return emptyList()
    }

}
