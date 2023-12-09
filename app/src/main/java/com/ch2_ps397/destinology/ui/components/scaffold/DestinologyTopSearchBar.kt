package com.ch2_ps397.destinology.ui.components.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.LightGray
import com.ch2_ps397.destinology.ui.theme.Orange
import com.ch2_ps397.destinology.ui.theme.OrangeLight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologySearchBar(onSearch: (query: String) -> Unit) {

    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Box(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .semantics { isTraversalGroup = true }
            .padding(16.dp)
    ) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = -1f },
            query = text,
            onQueryChange = { text = it },
            onSearch = {
                active = false
                onSearch(text)
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = { Text("Cari") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            colors = SearchBarDefaults.colors(
                containerColor = LightGray,
                dividerColor = Orange,
            )
        ) {
            LazyColumn(
                contentPadding = PaddingValues(start = 16.dp, top = 72.dp, end = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                for (i in 1..6) {
                    item { 
                        Text(text = "Item $i")
                    }
                }
            }
        }
    }
}