import org.junit.Test

class DemoBuildPluginTest {
    @Test
    fun `test1`() {
        val a = 0.0
        val b = 0.00

        assert(a == b)
    }

    @Test
    fun `test2`() {
        val a = 0.0
        val b = 0.00

        assert(a != b)
    }

}