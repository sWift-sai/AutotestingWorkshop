package sai.swift.autotestingworkshop.camera_grouper.steps

import org.assertj.core.api.Assertions.fail
import org.junit.Test

// Описываем тесты-требования
class CameraGrouperTest_Step2 {

    @Test
    fun `when transform - while has no cameras - should return empty list of groups`() {
        fail("unimplemented")
    }

    @Test
    fun `when transform - while has one not favorite camera - should return ALL group with that camera`() {
        fail("unimplemented")
    }

    @Test
    fun `when transform - while has one favorite camera - should return ordered FAVORITE and ALL groups with that camera`() {
        fail("unimplemented")
    }

    @Test
    fun `when transform - while has favorite and not favorite cameras - should return ordered FAVORITE group with favorite camera and ALL group with all cameras`() {
        fail("unimplemented")
    }

    @Test
    fun `when transform - while has inactive favorite and not favorite cameras - should return empty list of groups`() {
        fail("unimplemented")
    }

    @Test
    fun `when transform - while has active and inactive favorite and not favorite cameras - should skip inactive and return ordered FAVORITE group with favorite camera and ALL group with all cameras`() {
        fail("unimplemented")
    }

}