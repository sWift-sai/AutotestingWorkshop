package sai.swift.autotestingworkshop.camera_grouper.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sai.swift.autotestingworkshop.camera_grouper.Camera
import sai.swift.autotestingworkshop.camera_grouper.CameraGroup
import sai.swift.autotestingworkshop.camera_grouper.CameraGroupType
import sai.swift.autotestingworkshop.camera_grouper.CameraGrouper
import sai.swift.autotestingworkshop.internal.generator.CameraGenerator.createCamera

// Реализуем все тесты
class CameraGrouperTest_Step3 {

    private val cameraGrouper = CameraGrouper()

    @Test
    fun `when transform - while has no cameras - should return empty list of groups`() {
        // given
        val cameras = emptyList<Camera>()

        // when
        val result = cameraGrouper.transformCamerasToGroups(cameras)

        // then
        assertThat(result).isEmpty()
    }

    @Test
    fun `when transform - while has one not favorite camera - should return ALL group with that camera`() {
        // given
        val cameras = listOf(createCamera())

        // when
        val result = cameraGrouper.transformCamerasToGroups(cameras)

        // then
        val expectedGroups = listOf(
            CameraGroup(
                CameraGroupType.ALL,
                cameras
            )
        )
        assertThat(result).isEqualTo(expectedGroups)
    }

    @Test
    fun `when transform - while has one favorite camera - should return ordered FAVORITE and ALL groups with that camera`() {
        // given
        val cameras = listOf(createCamera(isFavorite = true))

        // when
        val result = cameraGrouper.transformCamerasToGroups(cameras)

        // then
        val expectedGroups = listOf(
            CameraGroup(
                CameraGroupType.FAVORITE,
                cameras
            ),
            CameraGroup(
                CameraGroupType.ALL,
                cameras
            )
        )
        assertThat(result).isEqualTo(expectedGroups)
    }

    @Test
    fun `when transform - while has not favorite and favorite cameras - should return ordered FAVORITE group with favorite camera and ALL group with all cameras`() {
        // given
        val notFavoriteCamera = createCamera()
        val favoriteCamera = createCamera(isFavorite = true)
        val cameras = listOf(
            notFavoriteCamera,
            favoriteCamera
        )

        // when
        val result = cameraGrouper.transformCamerasToGroups(cameras)

        // then
        val expectedGroups = listOf(
            CameraGroup(
                CameraGroupType.FAVORITE,
                listOf(favoriteCamera)
            ),
            CameraGroup(
                CameraGroupType.ALL,
                cameras
            )
        )
        assertThat(result).isEqualTo(expectedGroups)
    }

    @Test
    fun `when transform - while has inactive not favorite and favorite cameras - should return empty list of groups`() {
        // given
        val inactiveNotFavoriteCamera = createCamera(isActive = false)
        val inactiveFavoriteCamera = createCamera(isFavorite = true, isActive = false)
        val cameras = listOf(
            inactiveNotFavoriteCamera,
            inactiveFavoriteCamera
        )

        // when
        val result = cameraGrouper.transformCamerasToGroups(cameras)

        // then
        assertThat(result).isEmpty()
    }

    @Test
    fun `when transform - while has active and inactive not favorite and favorite cameras - should skip inactive and return ordered FAVORITE group with favorite camera and ALL group with all cameras`() {
        // given
        val inactiveNotFavoriteCamera = createCamera(isActive = false)
        val inactiveFavoriteCamera = createCamera(isFavorite = true, isActive = false)
        val notFavoriteCamera = createCamera()
        val favoriteCamera = createCamera(isFavorite = true)

        val cameras = listOf(
            inactiveFavoriteCamera,
            notFavoriteCamera,
            favoriteCamera,
            inactiveNotFavoriteCamera
        )

        // when
        val result = cameraGrouper.transformCamerasToGroups(cameras)

        // then
        val expectedGroups = listOf(
            CameraGroup(
                CameraGroupType.FAVORITE,
                listOf(favoriteCamera)
            ),
            CameraGroup(
                CameraGroupType.ALL,
                listOf(notFavoriteCamera, favoriteCamera)
            )
        )
        assertThat(result).isEqualTo(expectedGroups)
    }

}