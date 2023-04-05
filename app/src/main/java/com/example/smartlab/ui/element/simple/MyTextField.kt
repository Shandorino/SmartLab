package com.example.smartlab.ui.element.simple

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartlab.ui.theme.TextFieldBackground
import com.example.smartlab.ui.theme.TextFieldBorder


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    placeholder: String = ""
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(TextFieldBackground)
            .border(2.dp, TextFieldBorder, RoundedCornerShape(10.dp))

    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp, horizontal = 10.dp),
            keyboardOptions = keyboardOptions,
            decorationBox = @Composable {innerTextField ->
                TextFieldDefaults.TextFieldDecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = remember { MutableInteractionSource() },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = TextFieldBackground),
                    placeholder = { Text(text = placeholder) }
                )
            }

        )
    }


}

@Preview
@Composable
fun TextFieldPreview() {
    MyTextField(value = "", onValueChange = {}, placeholder = "example@mail.ru")
}