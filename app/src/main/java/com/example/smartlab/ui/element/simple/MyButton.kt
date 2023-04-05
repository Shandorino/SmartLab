package com.example.smartlab.ui.element.simple

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartlab.ui.theme.ButtonActiveBackground
import com.example.smartlab.ui.theme.ButtonDisableBackground


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyButton(text: String, modifier: Modifier = Modifier, isActive: Boolean = true, onClick: () -> Unit) {

    val emptyFun = {}

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = if (isActive) ButtonActiveBackground else ButtonDisableBackground,
        onClick = if (isActive) onClick else emptyFun,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = text, color = Color.White)
        }
    }


}


@Preview
@Composable
fun MyButtonPreview() {
    MyButton(text = "Далее", onClick = {})
}