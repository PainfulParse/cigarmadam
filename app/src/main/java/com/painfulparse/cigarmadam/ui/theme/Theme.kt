import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.painfulparse.cigarmadam.ui.theme.*

@Composable
fun CigarMadamTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = CigarMadamTypography,
        content = content
    )
}

private val darkColorPalette = darkColors(
    primary = RichMahogany,
    primaryVariant = VintageLeather,
    secondary = WarmAmber,
    background = CharcoalBlack,
    surface = CharcoalBlack,
    onPrimary = CreamyBeige,
    onSecondary = CreamyBeige,
    onBackground = CreamyBeige,
    onSurface = CreamyBeige
)

private val lightColorPalette = lightColors(
    primary = RichMahogany,
    primaryVariant = VintageLeather,
    secondary = WarmAmber,
    background = CreamyBeige,
    surface = CreamyBeige,
    onPrimary = CharcoalBlack,
    onSecondary = CharcoalBlack,
    onBackground = CharcoalBlack,
    onSurface = CharcoalBlack
)
