package sai.swift.autotestingworkshop.camera_grouper

class CameraGrouper {

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
