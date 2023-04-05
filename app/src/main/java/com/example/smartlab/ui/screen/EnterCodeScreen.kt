package com.example.smartlab.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.example.smartlab.screenModel.AuthScreenModel
import com.example.smartlab.ui.theme.TextFieldBackground
import com.example.smartlab.ui.theme.TextFieldBorder

class EnterCodeScreen(private val email: String): Screen {

    @Composable
    override fun Content() {

        val screenModel = getScreenModel<AuthScreenModel>()

        var code by remember {
            mutableStateOf("")
        }

        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize().padding(15.dp)) {

            val textFieldFocus = remember {
                FocusRequester()
            }

            LaunchedEffect(Unit) {
                textFieldFocus.requestFocus()
            }

            BasicTextField(value = code, onValueChange = {
                if (code.length < 4) {
                    code = it
                }
            },
                cursorBrush = SolidColor(Color.Transparent),
                modifier = Modifier.focusRequester(textFieldFocus),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword),
                textStyle = TextStyle(color = Color.Transparent)
            )

            Row(Modifier.fillMaxWidth().padding(horizontal = 60.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(1.dp, color = TextFieldBorder, shape = RoundedCornerShape(10.dp))
                        .background(TextFieldBackground),
                    contentAlignment = Alignment.Center
                ) {
                    if (code.isNotEmpty()) Text(text = code[0].toString())
                }

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(1.dp, color = TextFieldBorder, shape = RoundedCornerShape(10.dp))
                        .background(TextFieldBackground),
                    contentAlignment = Alignment.Center
                ) {
                    if (code.length > 1) Text(text = code[1].toString())
                }
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(1.dp, color = TextFieldBorder, shape = RoundedCornerShape(10.dp))
                        .background(TextFieldBackground),
                    contentAlignment = Alignment.Center
                ) {
                    if (code.length > 2) Text(text = code[2].toString())
                }
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(1.dp, color = TextFieldBorder, shape = RoundedCornerShape(10.dp))
                        .background(TextFieldBackground),
                    contentAlignment = Alignment.Center
                ) {
                    if (code.length > 3) Text(text = code[3].toString())
                }


            }

        }



    }
}


@Preview
@Composable
fun EnterCodePreview() {

    EnterCodeScreen("asd")

}