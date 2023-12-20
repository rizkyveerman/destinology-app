package com.ch2_ps397.destinology.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ch2_ps397.destinology.ui.theme.Emerald
import com.ch2_ps397.destinology.ui.theme.Red
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinologyLabel(status: Boolean, text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (status) {
                    Emerald
                } else {
                    Red
                }
            )
            .padding(horizontal =  16.dp, vertical = 2.dp)
    ) {
        Text(text = text, color = White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}